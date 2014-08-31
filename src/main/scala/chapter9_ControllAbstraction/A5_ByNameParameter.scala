package chapter9_ControllAbstraction

/**
 * Created by katsuki on 2014/08/16.
 */
object A5_ByNameParameter {
  var assertionEnable = true
  def myAssert(predicate: () => Boolean) = {
    if (assertionEnable && !predicate())
      throw new AssertionError
  }

  def myAssert2(predicate: => Boolean) = {
    if (assertionEnable && !predicate)
      throw new AssertionError
  }

  def main(args: Array[String]) {
    myAssert(() => 5 > 3)
    myAssert2(5 > 6)
  }
}
