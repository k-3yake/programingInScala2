package chapter15_CaseClassAndPatternMatch

/**
 * Created by katsuki on 2014/08/18.
 */
class CaseSequenceOfPartialFunction {

}

object CaseSequenceOfPartialFunction{
  def main(args: Array[String]) {
    val withDefault: Option[Int] => Int = {
      case Some(x) => x
      case None => 0
    }
    assert(withDefault(Some(9)) == 9)
    assert(withDefault(None) == 0)

    val second: PartialFunction[List[Int],Int] = {
      case x :: y :: _ => y
    }
    assert(second(List(1,2,3)) == 2)
    assert(second.isDefinedAt(List(5,4,3))  == true )
    assert(second.isDefinedAt(List())  == false )
  }
}