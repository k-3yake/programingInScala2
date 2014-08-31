package chapter12_Traits.linearization

/**
 * Created by katsuki on 2014/08/17.
 */
class Animal {
  def greet(){
    println("animal")
  }
}
trait Furry extends Animal {
  abstract override def greet(){
    println("furry")
    super.greet()
  }
}
trait HasLegs extends Animal{
  abstract override def greet(){
    println("hasLeg")
    super.greet()
  }
}
trait FourLegs extends HasLegs{
  abstract override def greet(){
    println("FourLegs")
    super.greet()
  }
}
class Cat extends Animal with Furry with FourLegs

object Cat {
  def main(args: Array[String]) {
    val cat = new Cat
    cat.greet()
  }
}