/* Copyright 2018-20 Richard Oliver. Licensed under Apache Licence version 2.0. */
package ostrat
package geom
import Colour.Black, pWeb._

/** Short for polygon trait. The general case can be instantiated with [[PolygonImp]], but it provides the interface for particular sub sets of
 *  polygons such as triangles and square. Mathematically a closed polygon made up of straight line segments. */
trait Polygon extends Shape with BoundedElem
{
  def fTrans(f: Vec2 => Vec2): Polygon = vertsMap(f).toPolygon

  def foreachVert(f: Vec2 => Unit): Unit
  def foreachVertTail[U](f: Vec2 => U): Unit
  def ptsArray: Array[Double]
  
  def xVertsArray: Array[Double]
  def yVertsArray: Array[Double]
  def foreachPairTail[U](f: (Double, Double) => U): Unit

  def vertsMap[A, ArrT <: ArrBase[A]](f: Vec2 => A)(implicit build: ArrBuild[A, ArrT]): ArrT =
  { val acc = build.newBuff()
    foreachVert{ v => build.buffGrow(acc, f(v)) }
    build.buffToArr(acc)
  }
  def vertsFoldLeft[B](initial: B)(f: (B, Vec2) => B): B =
  { var acc: B = initial
    foreachVert{ v => acc = f(acc, v) }
    acc
  }

  def apply(index: Int): Vec2
  override def attribs: Arr[XANumeric] = ???
  override def cen: Vec2 = vertsFoldLeft(Vec2Z)(_ + _) / vertsNum
  override def fill(fillColour: Colour): PolygonFill = PolygonFill(this, fillColour)
  override def fillHex(intValue: Int): PolygonFill = PolygonFill(this, Colour(intValue))
  override def draw(lineWidth: Double = 2, lineColour: Colour = Black): PolygonDraw = PolygonDraw(this, lineWidth, lineColour)

  override def fillDraw(fillColour: Colour, lineWidth: Double, lineColour: Colour): PolygonCompound =
    PolygonCompound(this, Arr(FillFacet(fillColour), DrawFacet(lineWidth, lineColour)))

  /** The number of vertices and also the number of sides in this Polygon. */
  def vertsNum: Int

  /** Returns the X component of the vertex of the given number. Will throw an exception if the vertex index is out of range. */
  def xVertGet(index: Int): Double

  /** Returns the Y component of the vertex of the given number. Will throw an exception if the vertex index is out of range. */
  def yVertGet(index: Int): Double

  /** May throw on a 0 vertices polygon. */
  def x1: Double

  /** May throw on a 0 vertices polygon. */
  def y1: Double

  /** May throw on a 0 vertices polygon. */
  def v1: Vec2

  /** Currently throws, not sure if that is the correct behaviour. Creates a bounding rectangle for a collection of 2d points */
  override def boundingRect: BoundingRect =
  { var minX, maxX = xVertGet(0)
    var minY, maxY = yVertGet(0)
    foreachVertTail{v =>
      minX = minX.min(v.x)
      maxX = maxX.max(v.x)
      minY = minY.min(v.y)
      maxY = maxY.max(v.y)
    }
    BoundingRect(minX, maxX, minY, maxY)
  }

  @inline def polygonMap(f: Vec2 => Vec2): Polygon = vertsMap(f).toPolygon

  /** Translate geometric transformation on a Polygon returns a Polygon. The return type of this method will be narrowed further in most descendant
   *  traits / classes. The exceptions being those classes where the centring of the geometry at the origin is part of the type. */
  override def slate(offset: Vec2): Polygon = polygonMap(_ + offset)

  /** Translate geometric transformation on a Polygon returns a Polygon. The return type of this method will be narrowed  further in most descendant
   *  traits / classes. The exceptions being those classes where the centring of the geometry at the origin is part of the type. */
  override def slate(xOffset: Double, yOffset: Double): Polygon = polygonMap(_.addXY(xOffset, yOffset))

  /** Uniform scaling against both X and Y axes transformation on a polygon returning a Polygon. Use the xyScale method for differential scaling. The
   *  return type of this method will be narrowed further in descendant traits / classes. */
  override def scale(operand: Double): Polygon = polygonMap(_ * operand)

  /** Mirror, reflection transformation of a Polygon across the X axis, returns a Polygon. */
  override def negY: Polygon = polygonMap(_.negY)

  /** Mirror, reflection transformation of Polygon across the Y axis, returns a Polygon. */
  override def negX: Polygon = polygonMap(_.negX)

  /** Rotate 90 degrees anti clockwise or rotate 270 degrees clockwise 2D geometric transformation on a Polygon, returns a Polygon. The return type
   *  will be narrowed in sub traits / classes. */
  override def rotate90: Polygon = polygonMap(_.rotate90)

  /** Rotate 180 degrees 2D geometric transformation on a Polygon, returns a Polygon. The return type will be narrowed in sub traits / classes. */
  override def rotate180: Polygon = polygonMap(_.rotate180)

  /** Rotate 270 degrees anti clockwise or rotate 90 degrees clockwise 2D geometric transformation on a Polygon, returns a Polygon. The return type
   *  will be narrowed in sub traits / classes. */
  override def rotate270: Polygon= polygonMap(_.rotate270)

  /** Prolign 2d transformations, similar transformations that retain alignment with the axes. */
  override def prolign(matrix: ProlignMatrix): Polygon = polygonMap(_.prolign(matrix))

  /** Rotation 2D geometric transformation on a Polygon, taking the rotation as a scalar measured in radians, returns a Polygon. The Return type will
   *  be narrowed in some but not all sub traits / classes. */
  override def rotate(angle: Angle): Polygon = polygonMap(_.rotate(angle))

  /** Reflect 2D geometric transformation across a line, line segment or ray on a polygon, returns a Polygon. The Return type will be narrowed in sub
   *  traits / classes. */
  override def reflect(lineLike: LineLike): Polygon

  /** XY scaling 2D geometric transformation on a Polygon returns a Polygon. This allows different scaling factors across X and Y dimensions. The
   *  return type will be narrowed in some, but not all descendant Polygon types. */
  override def xyScale(xOperand: Double, yOperand: Double): Polygon


  /** Shear 2D geometric transformation along the X Axis on a Polygon, returns a Polygon. The return type will be narrowed in some but not all sub
   *  classes and traits. */
  override def xShear(operand: Double): Polygon = ???

  /** Shear 2D geometric transformation along the Y Axis on a Polygon, returns a Polygon. The return type will be narrowed in sub classes and traits.
   *  */
  override def yShear(operand: Double): Polygon = ???

  override def slateTo(newCen: Vec2): Polygon = ???

  /** Converts this closed Polygon to LineSegs. The LineSegs collection is empty of there are less than 2 vertices. */
  def toLineSegs: LineSegs =if (vertsNum > 1)
  { val res: LineSegs = LineSegs(vertsNum)
    for (i <- 0 until (vertsNum - 1)) res.unsafeSetElem(i, LineSeg(apply(i), apply(i + 1)))
    res.unsafeSetLast(LineSeg(apply(vertsNum - 1), v1))
    res
  }
  else LineSegs()

  /** Determines if the parenter point lies inside this Polygon. */
  def ptInside(pt: Vec2): Boolean = toLineSegs.ptInPolygon(pt)

  def polyCentre: Vec2 = boundingRect.cen

  def sline(index: Int): LineSeg =
  { val endVertNum: Int = ife(index == vertsNum - 1, 0, index + 1)
    LineSeg(apply(index), apply(endVertNum))
  }

  def sline0: LineSeg = sline(0)
  def sline1: LineSeg = sline(1)
  def sline2: LineSeg = sline(2)
  def sline3: LineSeg = sline(3)
  def sline4: LineSeg = sline(4)
  def sline5: LineSeg = sline(5)

  def active(id: Any): PolygonActive = PolygonActive(this, id)
  def activeChildren(id: Any, children: GraphicElems): PolygonCompound = PolygonCompound(this, Arr(), active(id) +: children)

  def fillActive(fillColour: Colour, pointerID: Any): PolygonCompound =
    PolygonCompound(this, Arr(FillFacet(fillColour)), Arr(PolygonActive(this, pointerID)))

  /** Creates a PolygonCompound graphic that is active with a simple 1 colour fill and has a draw graphic for the Polygon. The default values for the
   * draw area line width of 2 and a colour of Black. */
  def fillActiveDraw(fillColour: Colour, pointerID: Any, lineWidth: Double = 2, lineColour: Colour = Black): PolygonCompound =
    PolygonCompound(this, Arr(FillFacet(fillColour), DrawFacet(lineWidth, lineColour)), Arr(PolygonActive(this, pointerID)))

  def fillDrawActive(fillColour: Colour, pointerID: Any, lineWidth: Double, lineColour: Colour = Black): PolygonCompound =
    PolygonCompound(this, Arr(FillFacet(fillColour), DrawFacet(lineWidth, lineColour)), Arr(PolygonActive(this, pointerID)))

  def fillDrawText(fillColour: Colour, str: String, fontSize: Int = 24, lineWidth: Double = 2.0, lineColour: Colour = Black): PolygonCompound =
    PolygonCompound(this, Arr(FillFacet(fillColour), DrawFacet(lineWidth, lineColour)), Arr(TextGraphic(str, fontSize, cen)))

  def parentFillText(pointerID: Any, fillColour: Colour, str: String, fontSize: Int = 10, textColour: Colour = Black, align: TextAlign = CenAlign):
  PolygonCompound = PolygonCompound(this, Arr(FillFacet(fillColour), TextFacet(str, textColour)), Arr())
  //PolygonParentOld = PolygonParentOld.fillText(this.polyCentre, this, pointerID, fillColour, str, fontSize, textColour, align)

  def fillDrawTextActive(fillColour: Colour, pointerID: Any, str: String, fontSize: Int = 24, lineWidth: Double, lineColour: Colour = Black,
    align: TextAlign = CenAlign): PolygonCompound = PolygonCompound(this, Arr(FillFacet(fillColour), DrawFacet(lineWidth, lineColour)),
    Arr(TextGraphic(str, fontSize, cen, Black, align), PolygonActive(this, pointerID)))

  def fillText(fillColour: Colour, str: String, fontSize: Int = 10, textColour: Colour = Black, layer: Int = 0): PolygonCompound =
    PolygonCompound(this, Arr(FillFacet(fillColour)), Arr(TextGraphic(str, fontSize, cen, textColour)))

  def fillTextActive(fillColour: Colour, pointerEv: Any, str: String, fontSize: Int = 24, fontColour: Colour = Black, align: TextAlign = CenAlign):
    PolygonCompound = PolygonCompound(this, Arr(FillFacet(fillColour)),
      Arr(PolygonActive(this, pointerEv), TextGraphic(str, fontSize, cen, fontColour, align)))

  /** Insert vertice */
  def insVert(insertionPoint: Int, newVec: Vec2): Polygon =
  { val res = PolygonImp.factory(vertsNum + 1)
    (0 until insertionPoint).foreach(i => res.unsafeSetElem(i, apply(i)))
    res.unsafeSetElem(insertionPoint, newVec)
    (insertionPoint until vertsNum).foreach(i => res.unsafeSetElem(i + 1, apply(i)))
    res
  }

  /** Insert vertices */
  def insVerts(insertionPoint: Int, newVecs: Vec2 *): Polygon =
  { val res = PolygonImp.factory(vertsNum + newVecs.length)
    (0 until insertionPoint).foreach(i => res.unsafeSetElem(i, apply(i)))
    newVecs.iForeach((elem, i) => res.unsafeSetElem(insertionPoint + i, elem))
    (insertionPoint until vertsNum).foreach(i => res.unsafeSetElem(i + newVecs.length, apply(i)))
    res
  }
}

/** Companion object for the Polygon trait. */
object Polygon
{
  def apply(v1: Vec2, v2: Vec2, v3: Vec2, tail: Vec2 *): Polygon = PolygonImp(v1, v2, v3, tail: _*)

  implicit val eqImplicit: Eq[Polygon] = (p1, p2) => Eq.arrayImplicit[Double].eqv(p1.ptsArray, p2.ptsArray)

  //  ??? // Eq.arrayImplicit[Double].eqv(p1.arrayUnsafe, p2.arrayUnsafe)
 // implicit val persistImplicit: Persist[Polygon] = ???
   /* new ArrProdDbl2Persist[Vec2, PolygonGen]("Polygon")
  { override def fromArray(value: Array[Double]): PolygonGen = new PolygonGen(value)
  }*/

  implicit val slateImplicit: Slate[Polygon] = (obj: Polygon, offset: Vec2) => obj.slate(offset)
  implicit val scaleImplicit: Scale[Polygon] = (obj: Polygon, operand: Double) => obj.scale(operand)
  implicit val rotateImplicit: Rotate[Polygon] = (obj: Polygon, angle: Angle) => obj.rotate(angle)
  implicit val prolignImplicit: Prolign[Polygon] = (obj, matrix) => obj.prolign(matrix)
  implicit val XYScaleImplicit: XYScale[Polygon] = (obj, xOperand, yOperand) => obj.xyScale(xOperand, yOperand)
  
  implicit val reflectAxesImplicit: TransAxes[Polygon] = new TransAxes[Polygon]
  { override def negYT(obj: Polygon): Polygon = obj.negY
    override def negXT(obj: Polygon): Polygon = obj.negX
    override def rotate90T(obj: Polygon): Polygon = obj.rotate90
    override def rotate180T(obj: Polygon): Polygon = obj.rotate180
    override def rotate270T(obj: Polygon): Polygon = obj.rotate270
  }
  
  implicit val shearImplicit: Shear[Polygon] = new Shear[Polygon]
  { override def xShearT(obj: Polygon, yFactor: Double): Polygon = obj.xShear(yFactor)
    override def yShearT(obj: Polygon, xFactor: Double): Polygon = obj.yShear(xFactor)
  }
}