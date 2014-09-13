package chapter23_ForExpressionRevisited

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/10.
 */
class ConvertForLoopTest extends FunSuite {
  val list = List(1,2,3)
  val list2 = List(1,2)


  test("forループの変換"){
    var values1 = List[Integer]()
    for( x <- list) values1 = x :: values1

    var values2 = List[Integer]()
    list.foreach(x => (values2 = x :: values2))
    assert(values1 == values2)

    var values3 = List[Integer]()
    list.map(x => values3 = x :: values3)
    assert(values1 == values3)
  }

  test("forループの変換_少し複雑に"){
    var sum1 = 0
    for( v1 <- list; v2 <- list2) sum1 = (v1 + v2 + sum1)
    assert(sum1 == 21)

    var sum2 = 0
    list.foreach(v1 => list2.foreach(v2 => sum2 = (v1 + v2 + sum2)))
    assert(sum2 == 21)
  }

}
