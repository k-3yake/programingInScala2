package chapter7

/**
 * Created by katsuki on 2014/08/16.
 */
object MultiplicationFunctionProcessing {

  def main(args: Array[String]) {
    println(multiTable)
  }

  def multiTable = {
    val tableSeq = for(row <- 1 to 10) yield makeRow(row)
    tableSeq.mkString("¥n")
  }
  def makeRow(row: Int) = makeRowSeq(row).mkString("")
  def makeRowSeq(row: Int) = {
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }
  }
}