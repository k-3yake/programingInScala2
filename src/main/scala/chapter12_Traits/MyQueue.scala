package chapter12_Traits

/**
 * Created by katsuki on 2014/08/17.
 */
class MyQueue extends BasicIntQueue with Doubling

object MyQueue {
  def main(args: Array[String]) {
    val queue = new MyQueue
    queue.put(10)
    queue.put(20)
    println(queue.get())
    println(queue.get())
  }
}
