package chapter8

/**
 * Created by katsuki on 2014/08/16.
 */
object ContinuousParamater {

  def echo(args: String*){
    for(arg <- args) println(arg)
  }

  def main(args: Array[String]) {
    echo("hello","world")
    val arr = Array("ドキュメント","って","美味しいの?")
    echo(arr: _*)
  }
}
