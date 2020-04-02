package ostrat
import geom._, pGrid._

package object gOne
{
  def cenSideVertCoodText(grid: TileGrid, scale: Double): Refs[PaintElem] =
  {
    val cenTexts = grid.mapVecsRel(scale)((r, v) => TextGraphic(r.ycStr, 26, v))
    val sls: LinesDraw = grid.sideLinesAllRel(scale).draw(2.0)
    val sideTexts = grid.sidesMapRoordVecRel(scale){ (r, v) =>  TextGraphic(r.ycStr, 22, v, Colour.Blue) }
    val vertTexts = grid.vertsMapRoordVecRel(scale){ (r, v) =>  TextGraphic(r.ycStr, 20, v, Colour.Red) }

    cenTexts +- sls ++ sideTexts ++ vertTexts
  }
}