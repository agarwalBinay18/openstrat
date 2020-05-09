package ostrat
package pParse

/** Sorts tokens in to brace hierarchy. */
object bracesParse
{
  def apply(rem: ArrOff[Token], open: BracketOpen)(implicit arr: Arr[Token]): EMon2[BracketedStatements, ArrOff[Token]] =
  {
    val acc: Buff[BlockMember] = Buff()
    def loop(rem: ArrOff[Token]): EMon2[BracketedStatements, ArrOff[Token]] = rem match
    {
      case ArrOff0() => open.startPosn.bad2("Unclosed Brace")

      //This case is where an inner BracketBlock starts within the current BracketBlock
      case ArrOff1Tail(bo: BracketOpen, tail) => bracesParse(tail, bo).flatMap2{ (bracketBlock, remTokens) =>
        acc.append(bracketBlock)
        loop(remTokens)
      }

      case ArrOff1Tail(bc: BracketCloseToken, tail) =>
        if (bc.braces == open.braces) statementsParse(acc.toRefs).flatMap2 { g =>
          val res = BracketedStatements(g, bc.braces, open.startPosn, bc.startPosn)
          Good2(res, tail)
        }
        else bc.startPosn.bad2("Unexpected Closing Parenthesis")

      case ArrOff1Tail(nbt: BlockMember, tail) => { acc.append(nbt);  loop(tail) }
    }

    loop(rem)
  }
}