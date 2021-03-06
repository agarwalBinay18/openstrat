/* Copyright 2018-20 Richard Oliver. Licensed under Apache Licence version 2.0. */
package ostrat
package geom
import pWeb._

/** An isosceles triangle. This trait is implemented by the equilateral triangle, [[TriangleEqui]] and the general case [[TriangleIsos]]. */
trait TriangleIsos extends Triangle
{	def height: Double
  def x2: Double = ???
  def y2: Double = ???
  override def v2: Vec2 = ???
}

/** The general case of an isosceles triangle. */
final case class TriangleIsosGen(x1: Double, y1: Double, x3: Double, y3: Double, height: Double) extends TriangleIsos
{	type ThisT = TriangleIsosGen

  override def fTrans(f: Vec2 => Vec2): TriangleIsosGen = ???
  override def v2: Vec2 = ???
  override def attribs: Arr[XANumeric] = ???

  override def rotate(angle: Angle): TriangleIsosGen = ???

  override def negY: ThisT = fTrans(_.negY)
  override def negX: ThisT = fTrans(_.negX)
  override def reflect(lineLike: LineLike): Triangle = ???
  override def xyScale(xOperand: Double, yOperand: Double): Triangle = ???
  override def slateTo(newCen: Vec2): TriangleIsos = ???
}