package chapter9_ControllAbstraction

/**
 * Created by katsuki on 2014/08/16.
 */
object A3_Currying {
  def plainOldSum (x: Int, y: Int) = x + y
  def curriedSum(x: Int)(y: Int) = x + y

  def first(x: Int) = (y: Int) => x + y

  def main(args: Array[String]) {
    println(plainOldSum(1,2))

    println(curriedSum(1)(2))

    val second = first(1)
    println(second(2))

    val onePlus = curriedSum(1)_
    println(onePlus(2))
  }
}
