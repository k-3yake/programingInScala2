package chapter23_ForExpressionRevisited

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/08.
 */
class PersonTest extends FunSuite {

  val lara = Person("Lara",false)
  val bob = Person("Bob",true)
  val julie = Person("Julie",false,lara,bob)
  val persons = List(lara,bob,julie)

  test("全ての女性の名前を表示する"){
    val result = persons filter( p => !p.isMale) map ( p => p.name)
    assert(result == List("Lara","Julie"))
  }

  test("母と子の全てのペアを拾いだして名前を表示する"){
    val result = persons filter( p => !p.isMale) flatMap (p => (p.children map (c => (p.name,c.name))))
    assert(result == List(("Julie","Lara"),("Julie","Bob")))
  }

  test("母と子の全てのペアを拾いだして名前を表示する_for式版"){
    val result = for (p <- persons; c <- p.children; if !p.isMale) yield (p.name,c.name)
    assert(result == List(("Julie","Lara"),("Julie","Bob")))
  }
}
