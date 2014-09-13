package chapter23_ForExpressionRevisited

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/09.
 */
class BookTest extends FunSuite {

  test("著作が2冊ある著者取得のテスト"){
    assert(Books.twoBooksAuthors() == List("Ull Jef"))
  }

  test("重複排除のテスト"){
    assert(Books.removeDuplicate(List("a","b","c","b","c")) == List("a","b","c"))
  }
}
