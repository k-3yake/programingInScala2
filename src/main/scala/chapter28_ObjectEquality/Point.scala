package chapter28_ObjectEquality

/**
 * Created by katsuki on 2014/09/14.
 */
class Point {

  override def equals(other: Any) = other match {
    case other: Point =>
      other canEqual this
    case _ =>
      false
  }

  def canEqual(other: Any) = other.isInstanceOf[Point]
}
