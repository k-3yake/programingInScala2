package chapter16_WorkingWithLists

/**
 * Created by katsuki on 2014/08/19.
 */
class HigherOrder {

  def reversLeft[T](xs: List[T]):List[T] = {
    (List[T]() /: xs)((x1,x2) => x2::x1)
  }

}
