package chapter12_Traits

import scala.collection.mutable.ArrayBuffer
/**
 * Created by katsuki on 2014/08/17.
 */
class BasicIntQueue extends IntQueue{
  private val buf = new ArrayBuffer[Int]
  override def get() = buf.remove(0)
  override def put(x: Int) { buf += x}
}

object BasicIntQueue {
  def main(args: Array[String]) {
    val queue = new BasicIntQueue
    queue.put(10)
    queue.put(20)
    println(queue.get())
    println(queue.get())

    val queue2 = (new BasicIntQueue with Incrementing with Filtering)
    queue2.put(-1)
    queue2.put(-0)
    queue2.put(1)
    println(queue2.get())
    println(queue2.get())
  }
}
