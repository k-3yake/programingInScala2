package chapter3

import scala.io.Source

/**
 * Created by katsuki on 2014/08/15.
 */
object printFile {

  def main(args: Array[String]) {
    if(args.length > 0) {
      val lines = Source.fromFile(args(0)).getLines().toList
      val longetstLine = lines.reduceLeft((a,b) => if(a.length > b.length) a else b)
      val maxWidth = widthOfLength(longetstLine)
      for (line <- lines) {
        val numSpaces = maxWidth - widthOfLength(line)
        val padding = " " * numSpaces
        println(padding + line.length + " | " + line)
      }
    }
  }

  def widthOfLength(s: String) = s.length.toString.length

}
