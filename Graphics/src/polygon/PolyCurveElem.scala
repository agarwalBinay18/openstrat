/* Copyright 2018 Richard Oliver. Licensed under Apache Licence version 2.0. */
package ostrat
package geom
import Colour.Black

trait PolyCurveElem extends GraphicAffineElem with GraphicBoundedAffine
{ type ThisT <: PolyCurveElem
  def shape: PolyCurve
  def segsLen: Int = shape.elemsLen
  override def boundingRect: BoundingRect = shape.boundingRect
}

case class PolyCurveFill(shape: PolyCurve, colour: Colour) extends PolyCurveElem
{ override type ThisT = PolyCurveFill
  override def fTrans(f: Vec2 => Vec2) = PolyCurveFill(shape.fTrans(f), colour)
  override def rendToCanvas(cp: pCanv.CanvasPlatform): Unit = cp.shapeFill(shape, colour)
  def xCen: Double = ???
  def yCen: Double = ???
  def cen: Vec2 = ???
  override def slateTo(newCen: Vec2): PolyCurveFill = ???
}

case class PolyCurveDraw(shape: PolyCurve, lineWidth: Double, colour: Colour = Black) extends PolyCurveElem
{ override type ThisT = PolyCurveDraw
  override def fTrans(f: Vec2 => Vec2) = PolyCurveDraw(shape.fTrans(f), lineWidth, colour)
  override def rendToCanvas(cp: pCanv.CanvasPlatform): Unit = cp.shapeDraw(shape, lineWidth, colour)
  def xCen: Double = ???
  def yCen: Double = ???
  def cen: Vec2 = ???
  override def slateTo(newCen: Vec2): PolyCurveDraw = ???
}

case class PolyCurveFillDraw(shape: PolyCurve, fillColour: Colour, lineWidth: Double, lineColour: Colour = Black) extends PolyCurveElem
{ override type ThisT = PolyCurveFillDraw
  override def fTrans(f: Vec2 => Vec2) = PolyCurveFillDraw(shape.fTrans(f), fillColour, lineWidth, lineColour)

  override def rendToCanvas(cp: pCanv.CanvasPlatform): Unit =
  { cp.shapeFill(shape, fillColour)
    cp.shapeDraw(shape, lineWidth, lineColour)
  }
  def xCen: Double = ???
  def yCen: Double = ???
  def cen: Vec2 = ???
  override def slateTo(newCen: Vec2): PolyCurveFillDraw = ???
}

case class PolyCurveFillDrawText(shape: PolyCurve, fillColour: Colour, str: String, fontSize: Int = 24, lineWidth: Double = 2,
  lineColour: Colour = Black) extends PolyCurveElem
{ override type ThisT = PolyCurveFillDrawText
  override def fTrans(f: Vec2 => Vec2) = PolyCurveFillDrawText(shape.fTrans(f), fillColour, str,fontSize, lineWidth, lineColour)
  def drawOnly: PolyCurveDraw = PolyCurveDraw(shape, lineWidth, lineColour)
  def textOnly: TextGraphic = TextGraphic(str, fontSize, shape.boundingRect.cen, Black, CenAlign)
  def fillDrawOnly: PolyCurveFillDraw = PolyCurveFillDraw(shape, fillColour, lineWidth, lineColour)

  override def rendToCanvas(cp: pCanv.CanvasPlatform): Unit =
  { cp.shapeFill(shape, fillColour)
    cp.shapeDraw(shape, lineWidth, lineColour)
    cp.textGraphic(textOnly)
  }
  def xCen: Double = ???
  def yCen: Double = ???
  def cen: Vec2 = ???
  override def slateTo(newCen: Vec2): PolyCurveFillDrawText = ???
}

case class PolyCurveAll(shape: PolyCurve, pointerId: Any, str: String, fillColour: Colour, fontSize: Int = 24, lineWidth: Double = 2,
  lineColour: Colour = Black) extends PolyCurveElem with PolyCurveActive
{ override type ThisT = PolyCurveAll
  override def fTrans(f: Vec2 => Vec2) = PolyCurveAll(shape.fTrans(f), pointerId, str, fillColour, fontSize, lineWidth, lineColour)
  def drawOnly: PolyCurveDraw = PolyCurveDraw(shape, lineWidth, lineColour)
  def textOnly: TextGraphic = TextGraphic(str, fontSize, shape.boundingRect.cen, Black, CenAlign)
  def fillDrawOnly: PolyCurveFillDraw = PolyCurveFillDraw(shape, fillColour, lineWidth, lineColour)

  override def rendToCanvas(cp: pCanv.CanvasPlatform): Unit =
  { cp.shapeFill(shape, fillColour)
    cp.shapeDraw(shape, lineWidth, lineColour)
    cp.textGraphic(textOnly)
  }

  def xCen: Double = ???
  def yCen: Double = ???
  def cen: Vec2 = ???
  override def slateTo(newCen: Vec2): PolyCurveAll = ???
}