package chapter28_ObjectEquality

import java.lang.NoSuchFieldException

/**
 * Created by katsuki on 2014/09/14.
 */
object EmptyTree extends Tree[Nothing]{
  override def elem = throw new NoSuchFieldException()
  override def left = throw new NoSuchFieldException()
  override def right = throw new NoSuchFieldException()
}
