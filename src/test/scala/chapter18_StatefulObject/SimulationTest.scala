package chapter18_StatefulObject

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/24.
 */
class SimulationTest extends FunSuite {

  test("シュミレーション実行のテスト_ディレイの順番に追加した各種Actionを実行する"){
    class Simulation1 extends Simulation
    val sut = new Simulation1
    val action1 = new Action
    val action2 = new Action
    val action3 = new Action
    sut.afterDelay(3)(() => action1.doAction())
    sut.afterDelay(1)(() => action2.doAction())
    sut.afterDelay(2)(() => action3.doAction())
    //実行
    //検証
    sut.next()
    assert(action2.done == true)
    sut.next()
    assert(action3.done == true)
    sut.next()
    assert(action1.done == true)
  }

  class Action{
    var done = false
    def doAction(){
      println("true")
      this.done = true
    }
  }
}
