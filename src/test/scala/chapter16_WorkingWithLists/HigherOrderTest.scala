package chapter16_WorkingWithLists

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/19.
 */
class HigherOrderTest extends FunSuite {

  test("リスト反転のテスト_空のリストの場合"){
    val sut = new HigherOrder
    assert(sut.reversLeft(List()) == List())
  }

  test("リスト反転のテスト_要素が1つの場合"){
    val sut = new HigherOrder
    assert(sut.reversLeft(List(1)) == List(1))
  }

  test("リスト反転のテスト_要素が5つの場合"){
    val sut = new HigherOrder
    assert(sut.reversLeft(List(1,2,3,5,4)) == List(4,5,3,2,1))
  }

}
