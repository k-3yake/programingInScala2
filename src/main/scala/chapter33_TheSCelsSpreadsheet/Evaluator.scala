package chapter33_TheSCelsSpreadsheet

import scala.collection.mutable

/**
 * Created by katsuki on 2014/09/28.
 */
trait Evaluator { this: Model =>
  type Op = List[Double] => Double
  val operations = new mutable.HashMap[String,Op]()

  def evaluate(e: Formula): Double = try {
    e match {
      case Coord(row, column) =>
        cells(row)(column).value
      case Number(v) =>
        v
      case Textual(_) =>
        0
      case Application(function, arguments) =>
        val argVals = arguments flatMap evalList
        operations(function)(argVals)
    }
  }catch{
    case ex: Exception => Double.NaN
  }

  private def evalList(e: Formula): List[Double] = e match {
    case Range(_,_) => references(e) map (_.value)
    case _ => List(evaluate(e))
  }

  def references(e: Formula): List[Cell] = e match {
    case Coord(row,column) =>
      List(cells(row)(column))
    case Range(Coord(r1,c1),Coord(r2,c2)) =>
      for(row <- (r1 to r2).toList;column <- c1 to c2) yield cells(row)(column)
    case Application(function,arguments) =>
      arguments flatMap references
    case _ =>
      List()
  }
}