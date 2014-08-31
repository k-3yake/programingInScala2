package chapter7

/**
 * Created by katsuki on 2014/08/16.
 */
object ExceptionProcess {

  def half(n: Int): Int = {
    if (n % 2 == 0)
      n / 2
    else
      throw new RuntimeException("n must be even")
  }

  def main(args: Array[String]) {
     println(half(1))
  }
}
