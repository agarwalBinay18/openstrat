/* Copyright 2018 Richard Oliver. Licensed under Apache Licence version 2.0 */
package ostrat
package pParse

object GetStatements
{  
  def apply(tokens: Seq[Token]): EMonList[Statement] = fileLoop(tokens, Nil)
   
  /** The top level loop takes a token sequence input usually from a single source file stripping out the brackets and replacing them and the 
   *  intervening tokens with a Bracket Block. */
  private def fileLoop(rem: Seq[Token], acc: List[BlockMember]): EMonList[Statement] = rem match
  {
    case Seq() => statementLoop(acc, Nil, Nil)
    case Seq(bo: BracketOpen, tail @ _*) => bracketLoop(tail, Nil, bo).flatMap{pair =>
      val (bracketBlock, remTokens) = pair
      fileLoop(remTokens, acc :+ bracketBlock)               
    }
    
    case Seq(bc: BracketClose, _*) => bad1(bc, "Unexpected Closing Brace at top syntax level")
    case Seq(bm: BlockMember, tail @ _*) => fileLoop(tail, acc :+ bm)
  }  
   
  /** Sorts tokens in to brace hierarchy. */ 
  private def bracketLoop(rem: Seq[Token], acc: Seq[BlockMember], open: BracketOpen): EMon[(BracketBlock, Seq[Token])] = rem match
  {
    case Seq() => bad1(open, "Unclosed Brace")
    case Seq(bo: BracketOpen, tail @ _*) => bracketLoop(tail, Nil, bo).flatMap{pair =>
      val (bracketBlock, remTokens) = pair
      bracketLoop(remTokens, acc :+ bracketBlock, open)
    }
    
    case Seq(bc: BracketClose, tail @ _*) => open.matchingBracket(bc) match
    { case false => bad1(bc, "Unexpected Closing Parenthesis")
      case true => statementLoop(acc, Nil, Nil).map(g => (open.newBracketBlock(bc, g), tail))            
    }
    
    case Seq(nbt: BlockMember, tail @ _*) => bracketLoop(tail, acc :+ nbt, open)               
  }      
   
  private def statementLoop(rem: Seq[BlockMember], acc: List[Statement], subAcc: List[StatementMember]): EMonList[Statement] = rem match
  {
    case Seq() if subAcc.isEmpty => Good(acc)
    case Seq () => getStatement(subAcc, nullRef).map(acc :+ _)      
    
    case Seq(h, tail @ _*) => h match
    {
      case st: SemicolonToken if subAcc.isEmpty => statementLoop(tail, acc :+ EmptyStatement(st), Nil) 
      case st: SemicolonToken => getStatement(subAcc, Opt(st)).flatMap(g => statementLoop(tail, acc :+ g, Nil))         
      case sm: StatementMember => statementLoop(tail, acc, subAcc :+ sm)
      case u => excep("Statement Loop, impossible case")
    }
  }
   
  private def getStatement(statement: List[StatementMember], optSemi: Opt[SemicolonToken]): EMon[Statement] =
  {
    def loop(rem: List[StatementMember], acc: List[Clause], subAcc: List[ExprMember]): EMon[Statement] = rem match
    {
      case Nil if acc.isEmpty => getExpr(subAcc).map(g => MonoStatement(g, optSemi))
      case Nil if subAcc.isEmpty => Good(ClausedStatement(acc, optSemi))
      case Nil => getExpr(subAcc).map(g => ClausedStatement(acc :+ Clause(g, nullRef), optSemi))        
      case (ct: CommaToken) :: tail if subAcc.isEmpty=> loop(tail, acc :+ EmptyClause(ct), Nil)
      case (ct: CommaToken) :: tail => getExpr(subAcc).flatMap(g => loop(tail, acc :+ Clause(g , Opt(ct)), Nil))
      case (em: ExprMember) :: tail => loop(tail, acc, subAcc :+ em)
    }
    loop(statement, Nil, Nil)
  }
   
  private def getExpr(seg: List[ExprMember]): EMon[Expr] = assignments(seg, Nil)// sortBlocks(seg, Nil).flatMap {
  
  private def assignments(rem: List[ExprMember], acc: List[ExprMember]): EMon[Expr] = rem match
  {
    case Nil => getBlocks(acc)
    case (at: AsignToken) :: tail =>
    {
      val eLs = getBlocks(acc)
      val eRs = assignments(tail, Nil)
      eLs.map2[Expr, Expr](eRs, (ls, rs) => AsignExpr(at, ls, rs))
    }
    case h :: tail => assignments(tail, acc :+ h)
  }
  
  
  private def getBlocks(seg: List[ExprMember]): EMon[Expr] = sortBlocks(seg, Nil).flatMap {
    case Seq(e: Expr) => Good(e)      
    case s => bad1(s.head, "Unknown Expression sequence:" -- s.toString) 
  }
   
  private def sortBlocks(rem: List[ExprMember], acc: List[TokenOrBlock]): EMon[List[TokenOrBlock]] = rem match
  {
    case Nil => prefixPlus(acc, Nil)
    case (at: AlphaToken) :: (bb: BracketBlock) :: t2 =>
    {//typedSpan needs removal */
      val (blocks, tail) = rem.tail.typedSpan[BracketBlock](_.isInstanceOf[BracketBlock])
      sortBlocks(tail, acc :+ AlphaBracketExpr(at, blocks))               
    }
    case h :: tail => sortBlocks(tail, acc :+ h)
  }
      
  private def prefixPlus(rem: List[TokenOrBlock], acc: List[TokenOrBlock]): EMon[List[TokenOrBlock]] = rem match
  {
    case Nil => Good(acc)
    case (pp: PlusPreToken) :: (right: Expr) :: tail => prefixPlus(tail, acc :+ PreOpExpr(pp, right))
    case (pp: PlusPreToken) :: _ => bad1(pp, "Prefix operator not fillowed by expression")
    case h :: tail => prefixPlus(tail, acc :+ h)
  }
}
