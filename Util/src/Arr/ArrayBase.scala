package ostrat

trait ArrayBase[A] extends Any
{
  def length: Int
  def lenStr: String = length.toString

  def foreach[U](f: A => U): Unit
}