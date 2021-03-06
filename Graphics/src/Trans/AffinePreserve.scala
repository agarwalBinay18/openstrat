/* Copyright 2018-20 Richard Oliver. Licensed under Apache Licence version 2.0. */
package ostrat
package geom

/** A class that can transform itself in 2d geometry and can preserve its type across all affine transformations. This is a key trait, the object
 *  can be transformed in 2 dimensional space. Leaf classes must implement the single method fTrans(f: Vec2 => Vec2): T. The related trait
 *  TransDistable  does the same for fTrans(f: Dist2 => Dist2):  T.  */
trait AffinePreserve extends SimilarPreserve
{ type ThisT <: AffinePreserve
  override def xyScale(xOperand: Double, yOperand: Double): ThisT = fTrans(_.xyScale(xOperand, yOperand))
  override def xShear(operand: Double): ThisT = fTrans(_.xShear(operand))
  override def yShear(operand: Double): ThisT = fTrans(_.yShear(operand))
}