package chapter15_CaseClassAndPatternMatch
import chapter10_CompositionAndInheritance.Element
import chapter10_CompositionAndInheritance.Element._


sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

class ExprFormatter{
  val ret = System.getProperty("line.separator")
  def format(expr: Expr):Element = {
    expr match {
      case Var(x) => elem(x)
      case Number(x) =>
        def stripDot(s: String) = {
          if(s.endsWith(".0")) s.substring(0, s.length -2)
          else s
        }
        elem(stripDot(x.toString))
        //elemの直呼びをformatに
      case BinOp("/",expr1,expr2) =>
        def width(expr1: Expr,expr2: Expr)={
          format(expr1).width max format(expr2).width
        }
        format(expr1) above elem('-',width(expr1,expr2),1) above format(expr2)
      case BinOp(op,expr1,expr2) => format(expr1) beside elem(op) beside format(expr2)
    }
  }
}

object Expr {
  def simplifyTop(expr: Expr): Expr = {
    expr match {
      case Var("Fuck!") => Var("Oh!")
      case Var(name) => Var("Good Str " + name)
      case UnOp("-",UnOp("-",e)) => e
      case BinOp("+",e,Number(0)) => e
      case BinOp("*",e,Number(1)) => e
      //コンパイルエラー
      //case BinOp("*",x,x) => BinOp("+",x,Number(2))
      case BinOp("+",x,y) if x == y => BinOp("*",x,Number(2))
      case BinOp(_,_,_) => Var("It's something else.")
      case _ => expr
    }
  }

  def tupleDemo(expr: Any): String ={
    expr match {
      case (a,b,c) => "tuple :" + a + "," + b + "," + c
      case _ => "wilde"
    }
  }

  def describe(expr: Expr) = expr match {
    case Number(_) => "number"
    case Var(_) => "var"
    case _ => "etc"
  }

  def main(args: Array[String]) {
    val v = Var("x")
    println(v.name)
    val op = BinOp("+",Number(1),v)
    println(op.left)
    println(simplifyTop((UnOp("-", UnOp("-", Var("x"))))))
    assert(simplifyTop(BinOp("*",Var("x"),Number(0))) == Var("It's something else."))
    assert(simplifyTop(Var("a")) == Var("Good Str a"))
    assert(simplifyTop(Var("Fuck!")) == Var("Oh!"))
    assert(simplifyTop(BinOp("+",Var("x"),Var("x"))) == BinOp("*",Var("x"),Number(2)))
    assert(tupleDemo("a",1,1.2) == "tuple :a,1,1.2")
    assert(tupleDemo("a",1,1.2,"b") == "wilde")
    assert(describe(Var("a")) == "var")
  }
}