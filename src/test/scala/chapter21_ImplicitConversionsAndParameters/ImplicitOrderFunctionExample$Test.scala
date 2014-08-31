package chapter21_ImplicitConversionsAndParameters

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/31.
 */
class ImplicitOrderFunctionExample$Test extends FunSuite {

  test("関数を暗黙パラメータとして渡すテスト_リストが空の場合_例外が発生する") {
    intercept[IllegalArgumentException] {
      ImplicitOrderFunctionExample.maxListImpParam(List())
    }
  }

  test("関数を暗黙パラメータとして渡すテスト_Intで要素が複数の場合_最大値を取得する"){
    // 標準ライブラリのIntのordererが暗黙的に渡される.
    val max = ImplicitOrderFunctionExample.maxListImpParam(List(1,3,2))
    assert(max == 3)
  }

  test("関数を暗黙パラメータとして渡すテスト_Doubleで要素が複数の場合_最大値を取得する"){
    // 標準ライブラリのDoubleのordererが暗黙的に渡される.
    val max = ImplicitOrderFunctionExample.maxListImpParam(List(0.1,0.3,0.2))
    assert(max == 0.3)
  }

  test("関数を暗黙パラメータとして渡すテスト_要素が１つの場合_その要素を返す"){
    val max = ImplicitOrderFunctionExample.maxListImpParam(List(1))
    assert(max == 1)
  }
}