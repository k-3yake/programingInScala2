package chapter8

import scala.io.Source

/**
 * Created by katsuki on 2014/08/16.
 */
object LongLines {
  def main(args: Array[String]) {
    val width = 15
    val fileNames = Array("programingInScala.iml")
    for(fileName <- fileNames) processFile(fileName,width)
  }

  def processFile(filename: String, width: Int){
    val source = Source.fromFile(filename)
    for(line <- source.getLines()) processLine(line)

    def processLine(line: String){
      if(line.length < width) println(filename + ": " + line.trim)
    }
  }
}