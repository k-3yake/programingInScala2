package chapter20_AbstractMember

/**
 * Created by katsuki on 2014/08/29.
 */
trait RationalTrait {
  val numArg:Int
  val denomArg:Int
  val berInitVal = numArg;
  def afterInitVal = numArg;
}

trait LazyRationalTrait {
  val numArg:Int
  val denomArg:Int
  lazy val berInitVal = numArg;
  def afterInitVal = numArg;
}

