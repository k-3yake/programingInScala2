package chapter6

/**
 * Created by katsuki on 2014/08/16.
 */
class Rational(n: Int, d: Int) {
  require(d != 0)
  private val g = gcd(n.abs,d.abs)
  val number: Int = n/g
  val denom: Int = d/g
  def this(n: Int) = this(n,1)
  def + (that: Rational): Rational = {
    new Rational(
      number * that.denom + that.number * denom,
      denom * that.denom
    )
  }
  def + (that: Int): Rational = this + new Rational(that)
  def * (that: Rational) = {
    new Rational(
      number * that.number,
      denom * that.denom
    )
  }
  def lessThan(that: Rational) = this.number * that.denom < that.number * this.denom
  def max(that: Rational) = if(this.lessThan(that)) that else this
  override def toString = number + "/" + denom
  private def gcd(a: Int, b: Int):Int =
    if (b==0) a else gcd(b, a % b)
}

object DoRationalCalc{
  def main(args: Array[String]) {
    implicit def intToRational(x: Int) = new Rational(x)
    val r1: Rational = new Rational(2,10)
    val r2: Rational = new Rational(3,2)
    println(r1 + r2)
    println(r1 + 1)
    println(1 + r1)
    println(r1 * r2)
    println(r1.lessThan(r2))
    println(r1.max(r2))
  }
}