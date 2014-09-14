package chpater28_ObjectEquality

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/14.
 */
class PointTest extends FunSuite {

  test("同一性比較可能のテスト_ColoredPointとPointの場合_false"){
    assert(new ColoredPoint().canEqual(new Point()) == false)
  }

  test("同一性比較可能のテスト_ColoredPointとPointの場合_false"){
    assert(new ColoredPoint().canEqual(new Point()) == false)
  }

  test("同一性のテスト_ColoredPointとPointの場合_false"){
    //ColoredPointでないのでfalse
    assert(new ColoredPoint().equals(new Point()) == false)
  }

  test("同一性のテスト_PointとColoredPointの場合_false"){
    assert(new Point().equals(new ColoredPoint()) == false)
  }



}
