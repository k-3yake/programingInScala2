package chapter31_CombinatorPasing

import scala.util.parsing.combinator.JavaTokenParsers

/**
 * Created by katsuki on 2014/09/15.
 */
class Arith extends JavaTokenParsers{
  def expr: Parser[Any] = term~rep{"*"~term | "/"~term}
  def term: Parser[Any] = factor~rep{"+"~factor | "-"~factor}
  def factor: Parser[Any] = { floatingPointNumber | "(" + expr + ")"}
}
