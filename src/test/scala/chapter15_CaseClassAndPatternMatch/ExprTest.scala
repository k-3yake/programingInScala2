package chapter15_CaseClassAndPatternMatch

class ExprTest extends org.scalatest.FunSuite {
  val ret = System.getProperty("line.separator")
  val formatter = new ExprFormatter

  test("フォーマットのテスト_分数の場合"){
    val expr = BinOp("/",Var("x"),BinOp("+",Var("x"),Number(2)))
    //実行,検証
    assert(formatter.format(expr).toString ==
         " x " + ret
        +"---" + ret
        +"x+2"
    )
  }

  test("フォーマットのテスト_分数の加算をさらに分数にする場合"){
    val expr1 = BinOp("/",Var("a"),BinOp("*",Var("b"),Var("c")))
    val expr2 = BinOp("/",Number(1),Var("n"))
    val expr3 = BinOp("/",BinOp("+",expr1,expr2),Number(3))
    //実行,検証
    println(formatter.format(expr3).toString)
    assert(formatter.format(expr3).toString ==
      " a  1"+ ret
     +"---+-"+ ret
     +"b*c n"+ ret
     +"-----"+ ret
     +"  3  "

    )
  }
}