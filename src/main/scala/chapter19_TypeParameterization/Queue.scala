package chapter19_TypeParameterization

/**
 * Created by katsuki on 2014/08/26.
 */
trait Queue[+T] {
  def head():T
  def tail():Queue[T]
  def append[U >: T](value: U):Queue[U]
  def getValues:List[T]
}

object Queue{
  def apply[T](values: T*):Queue[T] = {
    new QueueImpl[T](values.toList,Nil)
  }

  private class QueueImpl[+T](private[this] var leading: List[T],private[this] var tailing: List[T]) extends Queue[T]{
    def mirror(){
      if(leading.isEmpty) {
        while(!tailing.isEmpty){
          leading = tailing.head :: leading
          tailing = tailing.tail
        }
      }
    }
    def head() ={
      mirror()
      leading.head
    }
    def tail() = {
      mirror()
      new QueueImpl[T](leading.tail, tailing)
    }
    def append[U >: T](value: U) = new QueueImpl[U](leading, value :: tailing)
    def getValues = leading
    override def toString():String ={
      "leading=" + leading + ":tailing=" + tailing
    }
  }

}