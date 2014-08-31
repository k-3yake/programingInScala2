package chapter2

/**
 * Created by katsuki on 2014/08/15.
 */
object forargs {
  def main(args: Array[String]) {
    for (arg <- args)
      println(arg)
  }
}
