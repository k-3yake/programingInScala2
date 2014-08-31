package chapter18_StatefulObject

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/25.
 */
class CircuitSimulationTest extends FunSuite{
  class CircuitSimulation1 extends CircuitSimulation{
    override def InverterDelay: Int = 1
    override def AndGateDelay: Int = 3
    override def OrGateDelay: Int = 5
  }

  test("半加算機のテスト_"){
    val sut = new CircuitSimulation1
    val input1,input2,sum,carry = new sut.Wire
    val sumProbe,carryProbe = new Probe
    sut.probe("sum",sum,sumProbe)
    sut.probe("carry",carry,carryProbe)
    sut.halfAdder(input1,input2,sum,carry)
    //実行
    input1.setSignal(true)
    sut.run()
    //検証
    assert(sumProbe.getSignal == true)
    assert(sumProbe.getCurrentTime == 8)
    assert(carryProbe.getCurrentTime == 0)
    //実行
    input2.setSignal(true)
    sut.run()
    assert(carryProbe.getSignal == true)
    assert(carryProbe.getCurrentTime == 11)
    assert(sumProbe.getSignal == false)
    assert(sumProbe.getCurrentTime == 15)



  }

}
