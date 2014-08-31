package chapter20_AbstractMember

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/29.
 */
class RationalTraitTest extends FunSuite {
  val numArg = -1

  test("初期化中の値のテスト_初期化中に値は反映されず0となる"){
    val rational = new RationalTrait {
      override val numArg: Int = 1
      override val denomArg: Int = 2
    }
    assert(rational.berInitVal == 0)
    assert(rational.afterInitVal == 1)
  }

  test("事前初期化子の値のテスト_初期化中に値は反映される"){
    val rational = new {
      override val numArg: Int = 1
      override val denomArg: Int = 2
    } with RationalTrait
    assert(rational.berInitVal == 1)
    assert(rational.afterInitVal == 1)
  }

  test("初期化子のthisのテスト_thisは初期化中のオブジェクトではなく初期化中のオブジェクトの包含するオブジェクトを指す"){
    val rational = new {
      override val numArg: Int = 1
      override val denomArg: Int = this.numArg
    } with RationalTrait
    assert(rational.denomArg == -1)
  }
}

class LazyRationalTraitTest extends FunSuite {
  test("遅延評価中の値のテスト_初期化中の値が反映される"){
    val rational = new LazyRationalTrait {
      override val numArg: Int = 1
      override val denomArg: Int = 2
    }
    assert(rational.berInitVal == 1)
    assert(rational.afterInitVal == 1)
  }
}

