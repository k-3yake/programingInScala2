package chapter31_CombinatorPasing

import scala.util.parsing.combinator.JavaTokenParsers

/**
 * Created by katsuki on 2014/09/15.
 */
class Arith extends JavaTokenParsers{
  def expr: Parser[Any] = expr~rep{"*"~expr | "/"~expr}
  def term: Parser[Any] = factor~rep{"+"~term | "-"~term}
  def factor: Parser[Any] = { floatingPointNumber | "(" + expr + ")"}

}
