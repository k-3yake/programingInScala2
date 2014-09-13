package chapter27_ModularProgrammingUsingObject

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/14.
 */
class SimpleDatabaseTest extends FunSuite {

  test("Foodの全件取得のテスト"){
    assert(SimpleDatabase.allFood() == List(Apple,Orange,Cream,Sugar))
  }

  test("Foodの名前検索_一致する名前のFoodがある場合_Foodを返す"){
    assert(SimpleDatabase.foodNamed("Apple") == Some(Apple))
  }

  test("Foodの名前検索_一致する名前のFoodがない場合_Noneを返す"){
    assert(SimpleDatabase.foodNamed("Packchi") == None)
  }

}
