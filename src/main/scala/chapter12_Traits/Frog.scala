package chapter12_Traits

/**
 * Created by katsuki on 2014/08/17.
 */
class Animal
trait HasReg

class Frog extends Animal with Philosophical with HasReg{
  override def toString = "green"
  override def philosophize() = println("Don't Think! Feel...")
}

object  Frog {
  def main(args: Array[String]) {
    val phil: Philosophical = new Frog
    phil.philosophize()
  }
}
