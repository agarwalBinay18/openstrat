/* Copyright 2018-20 Richard Oliver. Licensed under Apache Licence version 2.0. */
package ostrat
package geom
import math._, collection.mutable.ArrayBuffer

/** A 2 dimensional vector, can be used to represent 2 dimensional points and translations of 2 dimensional points. Thanks to Rene Descarte this
 *  was a great idea. */
final class Vec2 (val x: Double, val y: Double) extends ProdDbl2
{
  override def toString: String = Vec2.persistImplicit.show(this)
  override def canEqual(other: Any): Boolean = other.isInstanceOf[Vec2]
  @inline override def _1 = x
  @inline override def _2 = y
  override def productPrefix: String = "Vec2"

  /** Adds this Vector to a second 2 dimensional vector. */
  def +(operand: Vec2): Vec2 = Vec2(x + operand.x, y + operand.y)

  /** Subtracts the operand 2-idmensianl vecotr from this 2-dimensional vector. */
  def -(operand: Vec2): Vec2 = Vec2(x - operand.x, y - operand.y)
  /** The magnitude of this vector. */
  def magnitude = math.sqrt(x * x + y * y)

  /** Gives the positive scalar distance between this and the operand Vec2. */
  def distTo(operand: Vec2): Double = (operand - this).magnitude
  
  def midPtTo(otherPt: Vec2): Vec2 = (this + otherPt) / 2

  def strMod(f: Double => String): String = "Vec2".appendParenthSemis(f(x), f(y))
  def str1: String = strMod(_.str1)
  def str2: String = strMod(_.str2)
  def str3: String = strMod(_.str3)

  override def equals(other: Any): Boolean = other match
  { case Vec2(px, py) => (x =~ px) && (y =~ py)
    case _ => false
  }
  
  def doublesSeq = Seq(x, y)
  def toPair: (Double, Double) = (x, y)

  def addXY (otherX: Double, otherY: Double): Vec2 = Vec2(x + otherX, y + otherY)
  def subXY (otherX: Double, otherY: Double): Vec2 = Vec2(x - otherX, y - otherY)

  def unary_- : Vec2 = Vec2(-x, -y)
  @inline def *(factor: Double): Vec2 = Vec2(x * factor, y * factor)
  @inline def /(divisor: Double): Vec2 = Vec2(x / divisor, y / divisor)

  /** The dot product of this and the operand vector. */
  @inline def dot(operand: Vec2): Double = x * operand.x + y * operand.y

  def addX(adj: Double): Vec2 = Vec2(x + adj, y)
  def addY(adj: Double): Vec2 = Vec2(x, y + adj)
  def subX(adj: Double): Vec2 = Vec2(x - adj, y)
  def subY(adj: Double): Vec2 = Vec2(x, y - adj)

  def yScale(factor: Double): Vec2 = Vec2(x, y * factor)
  def xScale(factor: Double): Vec2 = Vec2(x * factor, y)
  def xyScale(xOperand: Double, yOperand: Double): Vec2 = Vec2(x * xOperand, y * yOperand)
  /** Reflects or mirrors this across a line. */
  def reflect(lineLike: LineLike): Vec2 = lineLike match {
    case xl: XLine => reflectXLine(xl)
    case yl: YLine => reflectYLine(yl)
    case r: Ray => ???  
    case lineSeg: LineSeg => {
      val v1 = lineSeg.pStart
      val v2 = lineSeg.pEnd
      val lineDelta: Vec2 = v2 - v1
      val lineUnitVector = lineDelta / lineDelta.magnitude
      2 * v1 - this - 2 * (v1 - this).dot(lineUnitVector) * lineUnitVector
    }
  }

  /** Reflects, mirrors this Vec2 across an XLine. */
  def reflectXLine(line: XLine): Vec2 = ???

  /** Reflects, mirrors this Vec2 across a YLine. */
  def reflectYLine(line: YLine): Vec2 = ???
  
  /** Reflects ,mirrors along the X axis by negating Y. */
  def negY: Vec2 = Vec2(x, -y)

  /** Reflects, mirrors along the Y axis by negating X. */
  def negX: Vec2 = Vec2(-x, y)

  /** Reflects, mirrors along the y = yOffset line that is parallel to the  X axis. */
  def reflectXParallel(yOffset: Double): Vec2 = Vec2(x, -y + yOffset * 2)

  /** Reflects, mirrors along the x = xOffset line, that is parallel to the Y axis by negating X. */
  def reflectYParallel(xOffset: Double): Vec2 = Vec2(-x + xOffset * 2, y)  
 
  def xShear(operand: Double): Vec2 = Vec2(x, y * operand)
  def yShear(operand: Double): Vec2 = Vec2(x * operand, y)

  @inline def prolign(m: ProlignMatrix): Vec2 = m.vecTrans(this)

  /** Where xnd y is a map on the surface ofa sphere. Currently not working for angles greater than Pi / 2 */
  def toLatLong(radius: Double): LatLong = LatLong.radians(math.acos(y / radius), math.acos(x / radius))

  /** Reverses the y coordinate. Useful for translating between canvases where the y axis measures down and coordinate systems where y is up */
  def inverseY: Vec2 = Vec2(x, -y)

  def toTuple: Tuple2[Double, Double] = (x, y)
  def vv(z: Double): Vec3 = Vec3(x, y, z)

  /** Gives the angle of the vector with respect of the origin in radians. */
  def angleRadians: Double =
  { def at = atan(y / x)
    x match
    {
      case _ if x == 0 & y == 0 => 0
      case _ if x == 0 & y > 0 => Pi / 2
      case _ if x == 0 => -Pi / 2
      case _ if x > 0 => at
      case _ if y > 0 => Pi + at
      case _ => at - Pi
      /*case x if x < - 0.0 && y < 0 => at - Pi
      case x if x < - 0.0 => Pi + at
      case x if x > 0.0 => at
      case _ if y < 0 => at -Pi/2
      case _ => at + Pi/2*/
    }
  }

  /** Gives the angle of the vector with respect of the origin in radians. */
  def angleRadiansPos: Double =
  { val at = atan(y / x)
    x match
    { case x if x < - 0.000000010 && y < 0 => at + Pi
      case x if x < - 0.00000001 => Pi + at
      case x if x > 0.00000001 => at
      case _ if y < 0 => at + Pi/2
      case _ => at + Pi/2
    }
  }
  
  /** rotates the vector 90 degrees or Pi/2 radians, anticlockwise. */
  @inline def rotate90: Vec2 = Vec2(-y, x)
  
  /** Rotates the vector 180 degrees or Pi radians. */
  @inline def rotate180: Vec2 = Vec2(-x, -y)

  /** rotates the vector 90 degrees or Pi/2 radians, clockwise. */
  @inline def rotate270: Vec2 = Vec2(y, -x)

  /** Gives the angle of the vector with respect of the origin. */
  def angle: Angle = Angle.radians(angleRadians)

  def lineTo(pt2: Vec2): LineSeg = LineSeg(this, pt2)

  /** Not sure about this method. */
  def lineAlong(angle: Angle, magnitude: Double): LineSeg = LineSeg(this, this + angle.toVec2(magnitude))

  /** Rotates this vector through the given angle around the origin. */
  def rotate(a: Angle): Vec2 = a match
  { case Deg0 => this
    case Deg90 => rotate90
    case Deg180 => rotate180
    case Deg270 => rotate270  
    case a => Vec2(x * a.cos - y * a.sin, x * a.sin + y * a.cos)
  }

  def rotateRadians(r: Double): Vec2 = Vec2(x * cos(r) - y * sin(r),
    { val ya = x * sin(r)
      val yb =y * cos(r)
      ya + yb
    })
   
  def centreSquare(length: Double): PolygonImp =
  { val r = length / 2.0
    PolygonImp(-r vv r, r vv r, r vv -r, -r vv -r).slate(x, y)
  }
   
  def fillText(str: String, fontSize: Int, fontColour: Colour = Colour.Black) = TextGraphic(str, fontSize, this, fontColour)
  def arcControlPoint(pt2: Vec2, arcCentre: Vec2): Vec2 =
  { val angle1 = (this - arcCentre).angle
    val angle2 = (pt2 - arcCentre).angle
    val resultAngle =  angle1.bisect(angle2)
    val alphaAngle =  resultAngle / 2
    val radius = (pt2 - arcCentre).magnitude
    arcCentre + resultAngle.toVec2(radius / alphaAngle.cos)
  }
  
  def linesCross(armLength: Double = 5): Seq[LineSeg] = Seq( new LineSeg(x - armLength, y , x + armLength, y),
    new LineSeg(x, y - armLength, x, y + armLength))
  
  /** Not sure about this method */
  def drawCross(armLength: Double, lineColour: Colour, lineWidth: Double): LinesDraw =
    LineSegs.doubles(x - armLength, y, x + armLength, y,
    x, y - armLength, x, y + armLength).draw(lineWidth, lineColour)

  def alignMatrix(matrix: AlignMatrix): Vec2 = Vec2(x * matrix.xFactor, y * matrix.yFactor) + matrix.vDelta
}

object Vec2
{ def apply(x: Double, y: Double): Vec2 = new Vec2(x, y)
  def unapply(orig: Vec2): Option[(Double, Double)] = Some((orig.x, orig.y))
  def fromAngle(angle: Angle, scalar: Double = 1.0): Vec2 = angle.toVec2(scalar)

  implicit class Vec2Implicit(thisVec: Vec2)
  { def * (operand: Dist): Dist2 = Dist2(thisVec.x * operand, thisVec.y * operand)
  }

  def circlePt(angle: Double): Vec2 = Vec2(cos(angle), sin(angle))
  def circlePtClockwise(angle: Double): Vec2 = Vec2(cos(angle), - sin(angle))
   
  implicit class Vec2IterableExtension(thisIter: Iterable[Vec2])
  { def toPolygon: PolygonImp = thisIter.toArrProdHomo
  }

  implicit val persistImplicit: PersistD2[Vec2] = new PersistD2[Vec2]("Vec2", "x", _.x, "y", _.y, apply)

  implicit val vec2sBuildImplicit: ArrProdDbl2Build[Vec2, Vec2s] = new ArrProdDbl2Build[Vec2, Vec2s]
  { type BuffT = Vec2Buff
    override def fromDblArray(array: Array[Double]): Vec2s = new Vec2s(array)
    def fromDblBuffer(inp: ArrayBuffer[Double]): Vec2Buff = new Vec2Buff(inp)
  }
}