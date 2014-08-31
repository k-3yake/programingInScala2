package chapter17_Collections

import org.scalatest.FunSuite
import scala.collection.immutable.{Queue => ImmutableQueue}
import scala.collection.mutable.{Queue => MutableQueue}


class QueueExampleTest extends FunSuite {

  test("immutableなQueueのテスト_コンストラクタから値を設定した場合_キューに値が追加される") {
    val queue = ImmutableQueue(1, 2, 3)
    val (element, rest) = queue.dequeue
    assert(element == 1)
    assert(rest == ImmutableQueue(2, 3))
  }

  test("immutableなQueueのテスト_値の追加をした場合_値はキューに追加されない") {
    val queue = ImmutableQueue(1, 2, 3)
    queue.enqueue(4)
    val (element, rest) = queue.dequeue
    assert(element == 1)
    assert(rest == ImmutableQueue(2, 3))
  }

  test("mutableなQueueのテスト_値の追加をした場合_値はキューに追加される") {
    val queue = MutableQueue(1, 2, 3)
    queue.enqueue(4)
    val (element) = queue.dequeue
    assert(element == 1)
    assert(queue == MutableQueue(2,3,4))
  }
}
