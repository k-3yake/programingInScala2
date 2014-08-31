package chapter8

/**
 * Created by katsuki on 2014/08/16.
 */
object TailRecursion {

  def approximate(guess: Double): Double = {
    if (isGoodEnough(guess)) guess else approximate(improve(guess))
  }
  def isGoodEnough(guess: Double) = {
    false //未実装
  }
  def improve(guess: Double) = {
    0.0 //未実装
  }

  def boom(x: Int): Int = {
    if (x == 0) throw new Exception("boom")
    else boom(x -1) + 1
  }

  def bang(x: Int): Int = {
    if (x == 0) throw new Exception("bang")
    else bang(x -1)
  }

  def main(args: Array[String]) {
    //boom(3)
    bang(3)
  }
}