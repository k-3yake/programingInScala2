package chapter19_TypeParameterization

/**
 * Created by katsuki on 2014/08/27.
 */
class ContravarianceOutputChanel[-T] {
  def write(x: T): String ={
    x.toString
  }
}

class ConvariantOutputChanel[+T] {
  def write[U >: T](x: U): String ={
    x.toString
  }
}
