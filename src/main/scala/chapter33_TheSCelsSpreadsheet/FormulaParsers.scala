package chapter33_TheSCelsSpreadsheet

import scala.util.parsing.combinator._

/**
 * Created by katsuki on 2014/09/27.
 */
object FormulaParsers extends RegexParsers{
  def ident: Parser[String] = """[a-zA-Z_]\w*""".r
  def decimal: Parser[String] = """-?\d+(\.\d*)?""".r
  def cell: Parser[Coord] =
    """[A-Za-z]\d+""".r ^^ { s =>
      val column = s.charAt(0) - 'A'
      val row = s.substring(1).toInt
      Coord(row,column)
    }
  def range: Parser[Range] = cell~":"~cell ^^ {    case c1~":"~c2 => Range(c1,c2)   }
  def number: Parser[Number] = decimal ^^ { d=> Number(d.toDouble)}
  def application: Parser[Application] = ident~"("~repsep(exper,",")~")"^^ {
    case f~"("~ps~")" => Application(f,ps)
  }
  def exper: Parser[Formula] = range | cell | number | application
  def textual: Parser[Textual] = """[^=].* """.r ^^ Textual
  def formula: Parser[Formula] = number | textual | "="~>exper
  def parse(input: String): Formula =
  parseAll(formula,input) match {
    case Success(e,_) => e
    case f: NoSuccess => Textual("[" + f.msg + "]")
  }
}
