package chapter17_Collections

import javax.management.JMX

import org.scalatest.FunSuite
import scala.collection.immutable.{Stack => ImmutableStack}
import scala.collection.mutable.{Stack => MutableStack}
import java.util.NoSuchElementException



/**
 * Created by katsuki on 2014/08/23.
 */
class StackTess extends FunSuite{

  test("Immutableなスタックのテスト_追加をした場合_値は追加される"){
    val stack = ImmutableStack()
    stack.push(1)
    intercept[NoSuchElementException]{
      stack.pop
    }
  }

  test("Mutableなスタックのテスト_追加をした場合_値は追加される"){
    val stack = MutableStack[Int]()
    stack.push(1)
    assert(stack.pop == 1)
  }
}
