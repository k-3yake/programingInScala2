package chapter24_Extractor

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/12.
 */
class UpperCaseTest extends FunSuite {

  test("変数の無い抽出子UpperCaseのテスト_全て大文字の場合_エラーなし"){
    val UpperCase() = "TEST"
  }

  test("変数の無い抽出子UpperCaseのテスト_小文字がある場合_エラー") {
    intercept[MatchError] {
      val UpperCase() = "TESt"
    }
  }
}
