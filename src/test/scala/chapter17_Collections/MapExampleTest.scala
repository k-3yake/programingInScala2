package chapter17_Collections

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/23.
 */
class MapExampleTest extends FunSuite {

  test("単語数算出のテスト__単語数を返す"){
    assert(new MapExample().countWord("a b a bb") == Map("a" -> 2,"b" -> 1,"bb" -> 1))
  }

}
