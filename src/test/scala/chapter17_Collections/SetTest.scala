package chapter17_Collections

import org.scalatest.FunSuite
import scala.collection.mutable
import scala.collection.immutable

/**
 * Created by katsuki on 2014/08/23.
 */
class SetTest extends FunSuite{

  test("mutableからimmutableへの変換のテスト"){
    val treeSet = immutable.TreeSet("blue","yellow","red","green")
    val mutableSet = mutable.Set.empty ++ treeSet
    val immutableSet = immutable.Set.empty ++ mutableSet
    assert(immutableSet == immutable.Set("blue","yellow","red","green"))
  }

}
