package ostrat
package pGrid
import geom._
trait TileGridReg extends TileGrid
{
  def sideCoodsAll: Coods = ???
  def coodToVec2(cood: Cood): Vec2
  def coodToVec2Rel(cood: Cood, gridPosn: Vec2 = cen): Vec2 = coodToVec2(cood) - gridPosn
  def sideCoodsOfTile(tileCood: Cood): Coods
  def sideCoodToCoodLine(sideCood: Cood): CoodLine
  def xCen: Double
  def cen = Vec2(xCen, yCen)
  final def sideCoodToLine(sideCood: Cood): Line2 = sideCoodToCoodLine(sideCood).toLine2(coodToVec2(_))

  final def sideLinesAll : Line2s = tilesAllFlatMap { cood =>
    val c1: Coods = sideCoodsOfTile(cood)
    val c2s: Line2s = c1.map(orig => sideCoodToLine(orig))
    c2s
  }

  /** This gives the tile grid lines in a single colour and line width. */
  def sideLinesAllDraw(lineWidth: Double = 2.0, colour: Colour = Colour.Black): LinesDraw = LinesDraw(sideLinesAll, lineWidth, colour)
  /** The centre of the grid by the x coordinate. */
  //def xCen: Double = (xTileMin + xTileMax) / 2.0
  /** The centre of the grid by the y coordinate. */
  def yCen: Double = (yTileMin + yTileMax) / 2.0
}
