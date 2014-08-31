package chapter16_WorkingWithLists

class FirstOrder {

  def append[T](xs: List[T], ys: List[T]): List[T] = {
    xs match {
      case List() => ys
      case xsHead::xsRest => xsHead::append(xsRest,ys)
    }
  }

  def msort[T](less: (T,T) => Boolean)(xs: List[T]):List[T] = {
    println("msort=" + xs)

    def merge(xs: List[T], ys: List[T]): List[T] =  (xs,ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        println("x=" + x + ",xs1=" + xs1 + ",y=" + y + ",ys1=" + ys1)
        val result = if (less(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
        println("rsult=" + result)
        result
    }
    val n = xs.length / 2
    if(n == 0) xs
    else{
      val (ys,zs) = xs splitAt n
      println("beforeMerge=" + ys + zs)
      val result = merge(msort(less)(ys), msort(less)(zs))
      println("afterMerge=" + result)
      result
    }
  }

  def msortSwaped[T](xs: List[T])(less: (T,T) => Boolean):List[T] = {
    null;
  }
}
