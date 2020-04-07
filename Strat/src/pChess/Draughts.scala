/* Copyright 2018 Richard Oliver. Licensed under Apache Licence version 2.0 */
package ostrat
package pChess
import pGrid._

case class Draughts(turn: Int, ltMen: List[Cood], ltKings: List[Cood], dkMen: List[Cood], dkKings: List[Cood])
{
  def ltPieces = ltMen ++ ltKings
  def dkPieces = dkMen ++ dkKings
  def pieces =  ltPieces ++ dkPieces
  private[this] def inner(ltMen: List[Cood], ltKings: List[Cood], dkMen: List[Cood], dkKings: List[Cood]) =
    Some(Draughts(turn + 1, ltMen: List[Cood], ltKings, dkMen, dkKings))
  
  def ltTurn(inp: List[Cood]): Option[Draughts] =
  {    
    inp match
    {
      case _ if inp.length < 2 => None
      case List(s, e) if ltMen.contains(s) & !pieces.contains(e) & e.yi == s.yi + 1 & eqOf(e.xi - s.xi, -1, 1) =>
        inner(ltMen.replace(s, e), ltKings, dkMen, dkKings)
      case _ => None
    }
  }
  
  def dkTurn(inp: List[Cood]): Option[Draughts] =
  {    
    inp match
    {
      case _ if inp.length < 2 => None
      case List(s, e) if dkMen.contains(s) & !pieces.contains(e) & e.yi == s.yi - 1 & eqOf(e.xi - s.xi, -1, 1) =>
        inner(ltMen, ltKings, dkMen.replace(s, e), dkKings)
      case _ => None
    }
  }
  
}
//  val tiles: Seq[CheckersSq] = for { y <- 1 to rowSize; x <- 1 to rowSize } yield Cood(x, y) match
//  { case c @ Cood(x, y) if c.evenSum & y <= 3 => DarkSq(x, y, Some(BlackPiece))
//    case c @ Cood(x, y) if c.evenSum & y >= 6 => DarkSq(x, y, Some(WhitePiece))
//    case c @ Cood(x, y) if c.evenSum          => DarkSq(x, y, None)
//    case c @ Cood(x, y)                           => LightSq(x, y)
//  }
object Draughts
{
  def start: Draughts =
  {
    val xs = (0 to 3).toList.map(_ * 2)
    def f(dx: Int, y: Int): List[Cood] = xs.map(x => Cood(x + dx, y))
    val ltMen = f(1, 1) ++ f(2, 2) ++ f(1, 3)
    val dkMen = f(2, 6) ++ f(1, 7) ++ f(2, 8)
    Draughts(0, ltMen, Nil, dkMen, Nil)
  }
}
