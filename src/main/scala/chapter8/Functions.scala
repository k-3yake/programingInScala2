package chapter8

/**
 * Created by katsuki on 2014/08/16.
 */
object Functions {

  def placeHolderExample(){
    val increase = (x: Int) => x + 1
    println(increase(10))
    val someNumbers = List(-11,-10,-5,0,5,10)
    someNumbers.foreach(print(_))
  }

  def sum(a: Int, b: Int, c: Int) = a + b + c

  def makeIncreaser(more: Int) = (x: Int) => x + more

  def main(args: Array[String]): Unit = {
    placeHolderExample()
    println()
    println(sum(1,2,3))
    val a = sum _
    println(a(2,4,6))
    val b = sum(1,_: Int,3)
    println(b(5))
    val more = 1
    val inc1 = makeIncreaser(1)
    println(inc1(3))
    val inc2 = makeIncreaser(2)
    println(inc2(3))
  }
}