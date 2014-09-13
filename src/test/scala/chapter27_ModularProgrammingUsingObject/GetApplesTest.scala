package chapter27_ModularProgrammingUsingObject

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/14.
 */
class GetApplesTest extends FunSuite {

  test("リンゴのレシピ取得のテスト_dbがstudentの場合_レシピはない"){
    assert(GetApples.exec("student") == List())
  }

  test("リンゴのレシピ取得のテスト_dbがstudent以外の場合_レシピはある"){
    assert(GetApples.exec("other")(0).name == "FruitsSalad")
  }
}
