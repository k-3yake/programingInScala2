package chapter23_ForExpressionRevisited

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/08.
 */
class QueensQuestionTest extends FunSuite {

  test("n女王問題のテスト_1辺が0マスの場合_解なし"){
    val result = QueensQuestion().queens(0)
    assert(result == List(List()))
  }

  test("n女王問題のテスト_1辺が1マスの場合_(1,1)"){
    val result = QueensQuestion().queens(1)
    assert(result == List(List(Tuple2(1,1))))
  }

  test("n女王問題のテスト_1辺が4マスの場合_解は2個"){
    val result = QueensQuestion().queens(4)
    println("result=" + result)
    assert(result.length == 2)
  }

  test("n女王問題のテスト_1辺が8マスの場合_解は92個"){
    val result = QueensQuestion().queens(8)
    println("result=" + result)
    assert(result.length == 92)
  }

  test("配置可能判定のテスト_同一段の駒がある場合_配置不能"){
    val result = QueensQuestion().isSafety(Tuple2(1,1),List(Tuple2(2,3),Tuple2(1,2)))
    assert(result == false)
  }

  test("配置可能判定のテスト_同一行の駒がある場合_配置不能"){
    val result = QueensQuestion().isSafety(Tuple2(1,1),List(Tuple2(2,3),Tuple2(2,1)))
    assert(result == false)
  }

  test("配置可能判定のテスト_同一筋の駒がある場合1_配置不能"){
    val result = QueensQuestion().isSafety(Tuple2(1,1),List(Tuple2(2,3),Tuple2(3,3)))
    assert(result == false)
  }

  test("配置可能判定のテスト_同一筋の駒がある場合2_配置不能"){
    val result = QueensQuestion().isSafety(Tuple2(2,1),List(Tuple2(1,2),Tuple2(3,3)))
    assert(result == false)
  }

  test("配置可能判定のテスト_段行筋全て違う駒のみの場合_配備可能"){
    val result = QueensQuestion().isSafety(Tuple2(1,1),List(Tuple2(2,3),Tuple2(3,5)))
    assert(result == true)
  }



  test("for式のyieldの仕様の確認_listが返るはず"){
    val result = for ( x <- 1 to 3 ) yield x
    assert(result == List(1,2,3))
  }

  test("for式のyieldの仕様の確認_要素が無い場合List()が返るはず"){
    val result = for ( x <- 1 to 3; if false ) yield x
    assert(result == List())
  }

  test("for式のyieldの仕様の確認_要素が無くList(List())と結合した場合_List()が返るはず"){
    val result = for ( x <- 1 to 3; if false ) yield x :: List(List())
    assert(result == List())
  }

  test("Listの結合の仕様の確認_List(List())にList()を結合するとList(List(),List())になるはず"){
    val result = List() :: List(List())
    assert(result == List(List(),List()))
  }

}