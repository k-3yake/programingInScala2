package chapter23_ForExpressionRevisited

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/10.
 */
class SupportForExpressionTest extends FunSuite {
  test("for式をサポートするクラスでfor式を書いてみる") {
    val supportForExpression = new SupportForExpression()
    supportForExpression.map(x => x)
    for (x <- supportForExpression) yield x
    val notSupport = new NotSupport()
    //for (x <- notSupport) yield x //コンパイルエラー
  }

  class NotSupport
}
