package chapter16_WorkingWithLists

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/19.
 */
class FirstOrderTest extends FunSuite {

  test("リスト連結のテスト"){
    val sut =new FirstOrder()
    assert(sut.append(List(1),List(2)) == List(1,2))
  }

  test("マージソートのテスト"){
    val sut =new FirstOrder()
    assert(sut.msort((x: Int, y: Int) => x < y)(List(5,4,1,3,2,7)) == List(1,2,3,4,5,7))
  }


}
