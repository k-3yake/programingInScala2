package chapter19_TypeParameterization

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/27.
 */
class publicationTest extends FunSuite {

  test("ブックリスト取得のテスト"){
    def getTitle(book: Publication):String = book.title
    assert(Library.bookList(getTitle) == Set("book1","book2"))
  }
}
