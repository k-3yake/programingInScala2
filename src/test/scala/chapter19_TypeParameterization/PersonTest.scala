package chapter19_TypeParameterization

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/27.
 */
class PersonTest extends FunSuite {

  test("比較のテスト"){
    val bob = new Person("bob")
    val tom = new Person("tom")
    assert((bob < tom) == true)
  }

}
