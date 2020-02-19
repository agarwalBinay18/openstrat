/* Copyright 2018 Richard Oliver. Licensed under Apache Licence version 2.0 */
package ostrat
import pParse._

/** The classic Show type class. A functional version of toString .Mostly you will want to use Persist which not only gives the Show methods
 *   to String representation, but the methods to parse Strings back to objects of the type T. However it may often be useful to start with Show
 *   type class and upgrade it later to Persist[T]. */
trait Show[-T]
{
  def typeStr: String
  /** Provides the standard string representation for the object. */
  def show(obj: T): String
  
  /** Simple values such as Int, String, Double have a syntax depth of one. A Tuple3[String, Int, Double] has a depth of 2 */
  def syntaxDepth: Int  
  
  /** Return the defining member values of the type as a series of comma separated values without enclosing type information, note this will only
   *  happen if the syntax depth is less than 3. if it is 3 or greater return the full typed data. */
  def showComma(obj: T): String
  
  /** Return the defining member values of the type as a series of semicolon separated values without enclosing type information, note this will only
   *  happen if the syntax depth is less than 4. if it is 4 or greater return the full typed data. This method is not commonly needed but is useful
   *  for case classes with a single member. This method will rarely be used, as it is only applicable when the object is being shown stand alone and
   *  not as part of a containing object. So generally the full show method string will be desired. It may have uses for on the fly aggregation of
   *  strings. */
  def showSemi(obj: T): String
  
  /** For most objects showTyped will return the same value as show(obj: T), for PeristValues the value will be type enclosed. 4.showTyped
   * will return Int(4) */
  def showTyped(obj: T): String
 }

/* The companion object for the Show type class. Persist extends Show with UnShow. As its very unlikley that anyone would want to create an UnShow
   instance without a Show instance. Many Persist instances are placed inside the Show companion object. However type instances that themsleves
   one or more Show type instances as parameters require a specific Show instance. The Persist instance for these types will require corresponding
   Persist type instances, and these will be placed in the Persist companion object.
 */
object Show //extends ShowInstancesPriority2
{
  implicit val intPersistImplicit: Persist[Int] = new PersistSimple[Int]("Int") {
    //override def findUniqueFromStatements(sts: Statements): EMon[Int] =
    def show(obj: Int): String = obj.toString

    override def fromExpr(expr: Expr): EMon[Int] = expr match {
      case DecimalToken(_, i) => Good(i.toInt)
      case PreOpExpr(op, DecimalToken(_, i)) if op.srcStr == "+" => Good(i.toInt)
      case PreOpExpr(op, DecimalToken(_, i)) if op.srcStr == "-" => Good(-i.toInt)
      case _ => expr.exprParseErr[Int]
    }
  }

  implicit val doublePersistImplicit: Persist[Double] = new PersistSimple[Double]("DFloat")
  { def show(obj: Double): String = obj.toString
    override def fromExpr(expr: Expr): EMon[Double] = expr match
    { case DecimalToken(_, i) => Good(i.toDouble)
      case PreOpExpr(op, DecimalToken(_, i)) if op.srcStr == "+" => Good(i.toDouble)
      case PreOpExpr(op, DecimalToken(_, i)) if op.srcStr == "-" => Good(-(i.toDouble))
      /* case FloatToken(_, _, d) => Good(d)
       case PreOpExpr(op, FloatToken(_, _, d)) if op.srcStr == "+" => Good(d)
       case PreOpExpr(op, FloatToken(_, _, d)) if op.srcStr == "-" => Good(-d)
     */  case  _ => expr.exprParseErr[Double]
    }
  }

  implicit val longPersistImplicit: Persist[Long] = new PersistSimple[Long]("Long")
  { def show(obj: Long): String = obj.toString
    override def fromExpr(expr: Expr): EMon[Long] = expr match
    { case DecimalToken(_, i) => Good(i.toLong)
      case PreOpExpr(op, DecimalToken(_, i)) if op.srcStr == "+" => Good(i.toLong)
      case PreOpExpr(op, DecimalToken(_, i)) if op.srcStr == "-" => Good(-i.toLong)
      case  _ => expr.exprParseErr[Long]
    }
  }

  implicit val floatPersistImplicit: Persist[Float] = new PersistSimple[Float]("SFloat")
  { def show(obj: Float): String = obj.toString
    override def fromExpr(expr: Expr): EMon[Float] = expr match
    { case DecimalToken(_, i) => Good(i.toFloat)
      case PreOpExpr(op, DecimalToken(_, i)) if op.srcStr == "+" => Good(i.toFloat)
      case PreOpExpr(op, DecimalToken(_, i)) if op.srcStr == "-" => Good(-(i.toFloat))
      /*  case FloatToken(_, _, d) => Good(d.toFloat)
        case PreOpExpr(op, FloatToken(_, _, d)) if op.srcStr == "+" => Good(d.toFloat)
        case PreOpExpr(op, FloatToken(_, _, d)) if op.srcStr == "-" => Good(-d.toFloat)
       */ case  _ => expr.exprParseErr[Float]
    }
  }

  implicit val BooleanPersistImplicit: Persist[Boolean] = new PersistSimple[Boolean]("Bool")
  { override def show(obj: Boolean): String = obj.toString
    override def fromExpr(expr: Expr): EMon[Boolean] = expr match
    { case IdentifierLowerOnlyToken(_, str) if str == "true" => Good(true)
      case IdentifierLowerOnlyToken(_, str) if str == "false" => Good(false)
      case _ => expr.exprParseErr[Boolean]
    }
  }

  implicit val stringPersistImplicit: Persist[String] = new PersistSimple[String]("Str")
  { def show(obj: String): String = obj.enquote
    override def fromExpr(expr: Expr): EMon[String] = expr match
    { case StringToken(_, stringStr) => Good(stringStr)
      case  _ => expr.exprParseErr[String]
    }
  }

  implicit val charPersistImplicit: Persist[Char] = new PersistSimple[Char]("Char")
  { def show(obj: Char): String = obj.toString.enquote1
    override def fromExpr(expr: Expr): EMon[Char] = expr match
    { case CharToken(_, char) => Good(char)
      case  _ => expr.exprParseErr[Char]
    }
  }

  class ShowIterableClass[A, R <: Iterable[A]](val evA: Show[A]) extends ShowIterable[A, R]{}

  /** Implicit method for creating List[A: Show] instances. */
  implicit def listImplicit[A](implicit ev: Show[A]): Show[List[A]] = new ShowIterableClass[A, List[A]](ev)

  /** Implicit method for creating ::[A: Persist] instances. This seems to have to be a method rather directly using an implicit class */
  //implicit def consPersistImplicit[A](implicit ev: Persist[A]): Persist[::[A]] = new PersistConsImplicit[A](ev)

  implicit def nilPersistImplicit[A](implicit ev: Persist[A]): Persist[Nil.type] = new PersistNilImplicit[A](ev)

  implicit def vectorImplicit[A](implicit ev: Show[A]): Show[Vector[A]] = new ShowIterableClass[A, Vector[A]](ev)

  implicit val ArrayIntPersistImplicit: Persist[Array[Int]] = new PersistSeqLike[Int, Array[Int]](Show.intPersistImplicit)
  {
    override def showSemi(thisArray: Array[Int]): String = thisArray.map(evA.showComma(_)).semiFold
    override def showComma(thisArray: Array[Int]): String = thisArray.map(evA.show(_)).commaFold
    override def fromParameterStatements(sts: Refs[Statement]): EMon[Array[Int]] = TextPosn.empty.bad("ArrayInt from statements")
    override def fromClauses(clauses: Refs[Clause]): EMon[Array[Int]] = ???

    override def fromExpr(expr: Expr): EMon[Array[Int]] = expr match
    { case SemicolonToken(_) => Good(Array[Int]())
      case AlphaBracketExpr(IdentifierUpperToken(_, "Seq"), Refs2(SquareBlock(ts, _, _), ParenthBlock(sts, _, _))) => ???
      //sts.eMap[Int](_.errGet[Int](evA)).map(_.array)
      case e => bad1(expr, "Unknown Exoression for Seq")
    }
  }

  class ArrRefPersist[A <: AnyRef](ev: Persist[A]) extends PersistSeqLike[A, ArrOld[A]](ev)
  {
    override def showSemi(thisArr: ArrOld[A]): String = thisArr.map(ev.showComma(_)).semiFold
    override def showComma(thisArr: ArrOld[A]): String = thisArr.map(ev.show(_)).commaFold
    override def fromParameterStatements(sts: Refs[Statement]): EMon[ArrOld[A]] = ???
    override def fromClauses(clauses: Refs[Clause]): EMon[ArrOld[A]] = ???

    override def fromExpr(expr: ParseExpr): EMon[ArrOld[A]] =  expr match
    {
      case AlphaBracketExpr(IdentifierUpperToken(_, typeName), Refs1(ParenthBlock(sts, _, _))) if typeStr == typeName => ??? // fromParameterStatements(sts)
      case AlphaBracketExpr(IdentifierUpperToken(fp, typeName), _) => fp.bad(typeName -- "does not equal" -- typeStr)
      case _ => ??? // expr.exprParseErr[A](this)
    }
  }

  /** Implicit method for creating Array[A <: Persist] instances. This seems to have to be a method rather directly using an implicit class */
  implicit def arrayRefToPersist[A <: AnyRef](implicit ev: Persist[A]): Persist[Array[A]] = new ArrayRefPersist[A](ev)
  class ArrayRefPersist[A <: AnyRef](ev: Persist[A]) extends PersistSeqLike[A, Array[A]](ev)
  {
    override def showSemi(thisArray: Array[A]): String = thisArray.map(ev.showComma(_)).semiFold
    override def showComma(thisArray: Array[A]): String = thisArray.map(ev.show(_)).commaFold
    override def fromParameterStatements(sts: Refs[Statement]): EMon[Array[A]] = ???
    override def fromClauses(clauses: Refs[Clause]): EMon[Array[A]] = ???

    override def fromExpr(expr: ParseExpr): EMon[Array[A]] =  expr match
    {
      case AlphaBracketExpr(IdentifierLowerToken(_, typeName), Refs1(ParenthBlock(sts, _, _))) if typeStr == typeName => ??? // fromParameterStatements(sts)
      case AlphaBracketExpr(IdentifierLowerToken(fp, typeName), _) => fp.bad(typeName -- "does not equal" -- typeStr)
      case _ => ??? // expr.exprParseErr[A](this)
    }
  }

  /** Implicit method for creating Arr[A <: Show] instances. This seems to have to be a method rather directly using an implicit class */
  implicit def arraySeqImplicit[A](implicit ev: Show[A]): Show[collection.immutable.ArraySeq[A]] = new ShowSeqLike[A, ArrOld[A]]
  { override def evA: Show[A] = ev
    override def showSemi(thisArr: ArrOld[A]): String = thisArr.map(ev.showComma(_)).semiFold
    override def showComma(thisArr: ArrOld[A]): String = thisArr.map(ev.show(_)).commaFold
  }

  implicit def somePersistImplicit[A](implicit ev: Persist[A]): Persist[Some[A]] = new Persist[Some[A]]
  {
    override def typeStr: String = "Some" + ev.typeStr.enSquare
    override def syntaxDepth: Int = ev.syntaxDepth
    override def show(obj: Some[A]) = ev.show(obj.value)
    override def showSemi(obj: Some[A]) = ev.showSemi(obj.value)
    override def showComma(obj: Some[A]) = ev.showComma(obj.value)
    override def showTyped(obj: Some[A]) =ev.showTyped(obj.value)
    override def fromClauses(clauses: Refs[Clause]): EMon[Some[A]] = ev.fromClauses(clauses).map(Some(_))
    override def fromStatements(sts: Refs[Statement]): EMon[Some[A]] = ev.fromStatements(sts).map(Some(_))

    override def fromExpr(expr: Expr): EMon[Some[A]] = expr match
    { case AlphaBracketExpr(IdentifierUpperToken(_, "Some"), Refs1(ParenthBlock(Refs1(hs), _, _))) => ev.fromExpr(hs.expr).map(Some(_))
      case expr => ev.fromExpr(expr).map(Some(_))
    }
  }

  implicit val nonePersistImplicit: Persist[None.type] = new PersistSimple[None.type]("None")
  {
    override def show(obj: None.type) = ""
    def fromExpr(expr: Expr): EMon[None.type] = expr match
    {
      case IdentifierLowerOnlyToken(_, "None") => Good(None)
      case eet: EmptyExprToken => Good(None)
      case e => bad1(e, "None not found")
    }

    override def fromStatements(sts: Refs[Statement]): EMon[None.type] = ife(sts.empty, Good(None), sts.startPosn.bad("None not found."))
  }

  implicit def optionPersistImplicit[A](implicit evA: Persist[A]): Persist[Option[A]] =
    new PersistSum2[Option[A], Some[A], None.type](somePersistImplicit[A](evA), nonePersistImplicit)
    { override def typeStr: String = "Option" + evA.typeStr.enSquare
      override def syntaxDepth: Int = evA.syntaxDepth
    }
}

sealed trait ShowInstancesPriority2
{
  /** Implicit method for creating Seq[A: Persist] instances. This seems to have to be a method rather directly using an implicit class */
  implicit def seqPersistImplicit[T](implicit ev: Persist[T]): Persist[Seq[T]] = new PersistSeqImplicit[T](ev)
}