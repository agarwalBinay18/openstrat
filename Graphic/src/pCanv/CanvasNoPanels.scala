/* Copyright 2018 Richard Oliver. Licensed under Apache Licence version 2.0 */
package ostrat
package pCanv
import geom._

/** A canvas that is not divided up into panels. A panel is a portion of the canvas that has its own origin and is clipped. */
abstract class CanvasNoPanels(title: String) extends CanvasUser(title) with PanelLike
{      
  override def width = canv.width
  override def height = canv.height
   
  canv.mouseUp = (posn, button) => mouseUp(posn, button, subjs.ptInObjsOld(posn).toRefs)
      
  def refresh(): Unit =
  { canv.clear(backColour)
    subjs = paintObjs(canvObjs)//paintObjs paints the objects to the screen and returns a list of active objects
  }

  /** Repaints the canvas takes repeat parameters of GraphicElem. */
  def repaints(els: GraphicElem*): Unit = { canvObjs = els.toRefs; refresh() }

  /** Repaints the canvas using the deprecated interface with ArraySeq. */
  def repaintOld(els: ArrOld[GraphicElem]): Unit = { canvObjs = els.toRefs; refresh() }

  /** Repaints the canvas, takes a Refs collection as parameter. */
  def repaint(els: Refs[GraphicElem]): Unit = { canvObjs = els; refresh() }

  def timedRepaint(f: Integer => GraphicElems): Unit =
  { val combinedF: Integer => Unit = elapsed => repaint(f(elapsed))
    canv.startFramePermanent(combinedF)
  }

  def timedRepaint1(f: Integer => GraphicElem): Unit =
  { val combinedF: Integer => Unit = elapsed => repaints((f(elapsed)))
    canv.startFramePermanent(combinedF)
  }
}