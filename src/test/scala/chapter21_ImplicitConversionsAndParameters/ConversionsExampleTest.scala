package chapter21_ImplicitConversionsAndParameters

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/30.
 */
class ConversionsExampleTest extends FunSuite {

  test("Stringのの暗黙の型変換のテスト"){
    implicit def convertToFormat(s: String) = {
      new Format {}
    }
    assert("123".A == "A")
    //assert(1.A == "A") dummyメッソッド内の変換メソッドがスコープ内に無いためコンパイルエラー
  }

  def dummy{
    implicit def convertToFormat(s: Int) = {
      new Format {}
    }
  }
}
