package chapter27_ModularProgrammingUsingObject

import chapter27_ModularProgrammingUsingObject.SimpleDatabase.Apple
import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/14.
 */
class SimpleBrowserTest extends FunSuite {

  test("レシピ表示のテスト_foodを使用したレシピがある場合_レシピを返す"){
//    val apple = new Food("Apple")
    assert(SimpleBrowser.recipesUsing(Apple)(0).name == "FruitsSalad")
  }
  test("レシピ表示のテスト_Foodを使用したレシピがない場合_空を返す"){
    object phakchi extends Food("phakchi")
    assert(SimpleBrowser.recipesUsing(phakchi).isEmpty)
  }

  test("カテゴリ表示のテスト_カテゴリの文字列を返す"){
    assert(SimpleBrowser.displayCategory(SimpleDatabase.fruits) == "FoodCategory(fruits,List(Apple, Orange))")
  }
}