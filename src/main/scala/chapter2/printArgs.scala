package chapter2

/**
 * Created by katsuki on 2014/08/15.
 */
object printArgs {

  def main(args: Array[String]) {
    var i = 0
    while (i < args.length) {
      println(args(i))
      i += 1
    }
  }
}
