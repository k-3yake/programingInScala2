package chapter19_TypeParameterization

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/26.
 */
class QueueTest extends FunSuite {

  test("追加のテスト_元の変数には影響を与えないこと"){
    val queue = Queue(1,2,3)
    val appended = queue.append(4)
    assert(appended.tail().tail().tail().head() == 4)
    assert(queue.getValues == List(1,2,3))
  }

  test("先頭取得のテスト_元の変数には影響を与えないこと"){
    val queue = Queue(1,2,3)
    assert(queue.head == 1)
    assert(queue.getValues == List(1,2,3))
  }

  test("2番目以降取得のテスト_元の変数には影響を与えないこと"){
    val queue = Queue(1,2,3)
    assert(queue.tail.getValues == List(2,3))
    assert(queue.getValues == List(1,2,3))
  }

}
