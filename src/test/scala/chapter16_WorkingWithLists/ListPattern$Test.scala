package chapter16_WorkingWithLists

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/19.
 */
class ListPattern$Test extends FunSuite {

  test("インサートのテスト"){
    assert(ListPattern.insert(2,List(1,3)) == List(1,2,3))
  }

  test("インサートのテスト_列の最後に挿入される場合"){
    assert(ListPattern.insert(4,List(1,3)) == List(1,3,4))
  }

  test("ソートのテスト") {
    assert(ListPattern.isort(List(3,1,2)) == List(1,2,3))
  }

}
