package chapter28_ObjectEquality

/**
 * Created by katsuki on 2014/09/14.
 */
class Branch[+T](val elem: T,val left: Tree[T],val right: Tree[T]) extends Tree[T]{

  override def equals(other: Any) = other match {
    case that:Branch[_] =>
    elem == that.elem && left == that.left && right == that.right
    case _ => false
  }

}
