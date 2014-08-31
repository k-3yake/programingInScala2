package chapter20_AbstractMember

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/29.
 */
class AbstractTimeTest extends FunSuite {
  test("抽象varのgetter,setterのテスト"){
    val time: AbstractTime = Time()
    assert(time.hour == 1)
    //getterはコンパイルでhour()となる
    assert(time.minute == 10)

    //setterはコンパイルでhour_$eq(arg)となる
    time.hour =2
    assert(time.hour == 2)
  }
}
