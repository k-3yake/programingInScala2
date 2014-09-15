package chapter31_CombinatorPasing

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/15.
 */
class ArithTest extends FunSuite {

  test("パース実行のテスト_1文字目から6文字目までの解析に成功すること"){
    val arith = new Arith
    assert(arith.parseAll(arith.expr,"2 * 3").toString.startsWith("[1.6]") == true)
  }
}
