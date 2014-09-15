package chapter28_ObjectEquality

/**
 * Created by katsuki on 2014/09/14.
 */
class ColoredPoint extends Point{

  override def equals(other: Any) = other match {
    case that:ColoredPoint =>
      that canEqual this
    case _ =>
      false

  }

  override def canEqual(other: Any) = other.isInstanceOf[ColoredPoint]
}
