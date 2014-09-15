package chapter28_ObjectEquality

/**
 * Created by katsuki on 2014/09/14.
 */
trait Tree[+T] {
  def elem: T
  def left:Tree[T]
  def right:Tree[T]
}
