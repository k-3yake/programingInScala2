package chapter24_Extractor

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/12.
 */
class TwiceTest extends FunSuite {

  test("変数が1つの抽出子Twiceのテスト_同じ文字が２回続いている場合_その文字を返す"){
    val Twice(str) = "testtest"
    assert(str == "test")
  }

  test("変数が1つの抽出子Twiceのテスト_同じ文字が２回続いていない場合_エラー"){
    intercept[MatchError] {
      val Twice(str) = "testtesta"
    }
  }



}
