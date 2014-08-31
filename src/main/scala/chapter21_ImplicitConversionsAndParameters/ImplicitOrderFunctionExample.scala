package chapter21_ImplicitConversionsAndParameters

import java.lang.IllegalArgumentException

/**
 * Created by katsuki on 2014/08/31.
 */
object ImplicitOrderFunctionExample {
  //可視境界を使用。TはOrdered[T]として使用出来るという意味になる。
  //T => Ordered[T]を要求する。この関数はScalaで標準にimplicitされている。
  def maxListImpParam[T <% Ordered[T]](elements: List[T]): T = {
  //def maxListImpParam[T](elements: List[T])(implicit orderer: T => Ordered[T]): T = {
    elements match {
      case List()=>
        throw new IllegalArgumentException
      case List(x) =>
        x
      case x :: rest=>
        //暗黙的にmaxListImpParamのパラメータにordererが渡される
        val maxRest = maxListImpParam(rest)
        //xは>メソッドが無いため、暗黙的にif(order(x) > maxRest) x　となる
        if(x > maxRest) x
        else maxRest
    }
  }
}
