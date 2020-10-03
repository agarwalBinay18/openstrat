/* Copyright 2018-20 Richard Oliver. Licensed under Apache Licence version 2.0. */
package ostrat
package geom
import pCanv._, Colour.Black


/** Immutable Graphic element that defines and draws a Polygon. */
trait PolygonDraw extends ShapeDraw with PolygonGraphicSimple
{ //override def fTrans(f: Vec2 => Vec2): PolygonDraw = PolygonDraw(shape.fTrans(f), lineWidth, lineColour)
  override def rendToCanvas(cp: CanvasPlatform): Unit = cp.polygonDraw(shape, lineWidth, lineColour)  

  /** Translate geometric transformation on a PolygonDraw, returns a PolygonDraw. */
  override def slate(offset: Vec2): PolygonDraw = PolygonDraw(shape.slate(offset), lineWidth, lineColour)

  /** Translate geometric transformation on a PolygonDraw, returns a PolygonDraw. */
  override def slate(xOffset: Double, yOffset: Double): PolygonDraw = PolygonDraw(shape.slate(xOffset, yOffset), lineWidth, lineColour)

  /** Uniform scaling transformation a PolygonDraw, returns a PolygonDraw. */
  override def scale(operand: Double): PolygonDraw = PolygonDraw(shape.scale(operand), lineWidth, lineColour)

  /** Mirror, reflection transformation across the X axis upon a PolygonDraw returns a PolygonDraw. */
  override def negY: PolygonDraw = PolygonDraw(shape.negY, lineWidth, lineColour)

  /** Mirror, reflection transformation across the X axis upon a PolygonDraw returns a PolygonDraw. */
  override def negX: PolygonDraw = PolygonDraw(shape.negY, lineWidth, lineColour)

  /** Mirror, reflection transformation across the X axis upon a PolygonDraw returns a PolygonDraw. */
  override def prolign(matrix: ProlignMatrix): PolygonDraw = PolygonDraw(shape.prolign(matrix), lineWidth, lineColour)
  
  /** Mirror, rotate(radians) transformation across the X axis upon a PolygonDraw returns a PolygonDraw. */
  override def rotateRadians(radians: Double): PolygonDraw = PolygonDraw(shape.rotateRadians(radians), lineWidth, lineColour)
  
  /** Mirror, reflection transformation across the X axis upon a PolygonDraw returns a PolygonDraw. */
  override def reflect(lineLike: LineLike): PolygonDraw = PolygonDraw(shape.reflect(lineLike), lineWidth, lineColour)

  /** Independent X and Y dimension scaling upon a PolygonDraw returns a PolygonDraw. */
  override def xyScale(xOperand: Double, yOperand: Double): PolygonDraw = PolygonDraw(shape.xyScale(xOperand, yOperand), lineWidth, lineColour)
  
  /** Shear along the X axis upon a PolygonDraw returns a PolygonDraw. */
  override def xShear(operand: Double): PolygonDraw = PolygonDraw(shape.xShear(operand), lineWidth, lineColour)
  
  /** Shear along the Y axis upon a PolygonDraw returns a PolygonDraw. */
  override def yShear(operand: Double): PolygonDraw = PolygonDraw(shape.yShear(operand), lineWidth, lineColour)
}

object PolygonDraw
{
  def apply (shape: Polygon, lineWidth: Double = 2, lineColour: Colour = Black): PolygonDraw = PolygonDrawImp(shape, lineWidth, lineColour)

  implicit val slateImplicit: Slate[PolygonDraw] = (obj: PolygonDraw, offset: Vec2) => obj.slate(offset)
  implicit val scaleImplicit: Scale[PolygonDraw] = (obj: PolygonDraw, operand: Double) => obj.scale(operand)
  implicit val rotateImplicit: Rotate[PolygonDraw] = (obj: PolygonDraw, radians: Double) => obj.rotateRadians(radians)
  implicit val XYScaleImplicit: XYScale[PolygonDraw] = (obj, xOperand, yOperand) => obj.xyScale(xOperand, yOperand)
  implicit val prolignImplicit: Prolign[PolygonDraw] = (obj, matrix) => obj.prolign(matrix)

  implicit val reflectAxesImplicit: ReflectAxes[PolygonDraw] = new ReflectAxes[PolygonDraw]
  { override def negYT(obj: PolygonDraw): PolygonDraw = obj.negY
    override def negXT(obj: PolygonDraw): PolygonDraw = obj.negX
  }
  
  /*implicit val persistImplicit: Persist3[Polygon, Double, Colour, PolygonDraw] =
    Persist3("PolyFill", "poly", _.shape, "lineWidth", _.lineWidth, "colour", _.lineColour, apply)*/

  /** Immutable Graphic element that defines and draws a Polygon. */
  case class PolygonDrawImp(shape: Polygon, lineWidth: Double = 2, lineColour: Colour = Black) extends PolygonDraw
  { 
    override def rendToCanvas(cp: CanvasPlatform): Unit = cp.polygonDraw(shape, lineWidth, lineColour)
  }
}