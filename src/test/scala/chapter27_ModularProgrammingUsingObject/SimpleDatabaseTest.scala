package chapter27_ModularProgrammingUsingObject

import chapter27_ModularProgrammingUsingObject.SimpleDatabase.{Sugar, Cream, Orange, Apple}
import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/14.
 */
class SimpleDatabaseTest extends FunSuite {

  test("Foodの全件取得のテスト"){
    assert(SimpleDatabase.allFood() == List(Apple,Orange,Cream,Sugar))
  }

}
