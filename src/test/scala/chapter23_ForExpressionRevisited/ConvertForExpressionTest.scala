package chapter23_ForExpressionRevisited

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/10.
 */
class ConvertForExpressionTest extends FunSuite {
  val list  = List(1,2,3)
  val list2  = List(4,5,6)

  test("ジェネレータが1つの時のfor式の変換"){
    val forVal = for(x <- list) yield x
    val highFuncVal = list.map(x => x)
    assert(forVal == highFuncVal)
  }

  test("ジェネレータが1つと1個のフィルターのfor式の変換"){
    val forVal = for(x <- list if x != 2) yield x
    val highFuncVal = list.filter(x => x!= 2).map(x => x)
    assert(forVal == highFuncVal)
  }

  test("ジェネレータが1つと1個のフィルターのfor式の変換_フィルターの後ろにさらに要素が含まれる場合"){
    val forVal = for(x <- list if x != 2 ; y <- List(4,5)) yield x + y
    val highFuncVal = for(x <- list.filter(x => x!= 2); y <- List(4,5).map( y => y) ) yield x + y
    assert(forVal == List(1+4,1+5,3+4,3+5))
    assert(forVal == highFuncVal)
  }

  test("ジェネレータが2で始まるfor式の変換"){
    val forVal = for(x <- list ; y <- list2) yield x + y
    val highFuncVal = list.flatMap(x => list2.map(y => x + y))
    assert(forVal == highFuncVal)
  }

  test("組み込みの定義がある場合"){
    val forVal = for(x <- list ; y =1 ) yield x + y
    val highFuncVal = for( (x,y) <- for(x <- list) yield (x,1) ) yield x + y
    assert(forVal == highFuncVal)
  }
}
