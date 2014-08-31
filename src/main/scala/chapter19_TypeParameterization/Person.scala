package chapter19_TypeParameterization

/**
 * Created by katsuki on 2014/08/27.
 */
class Person(val name: String) extends Ordered[Person]{
  def compare(that: Person) = {
    name.compareToIgnoreCase(that.name)
  }
}
