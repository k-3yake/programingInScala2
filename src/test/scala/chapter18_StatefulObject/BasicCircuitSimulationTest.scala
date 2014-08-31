package chapter18_StatefulObject

import java.math.BigInteger

import chapter18_StatefulObject._
import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/24.
 */
class BasicCircuitSimulationTest extends FunSuite {
  class BasicCircuitSimulation1 extends BasicCircuitSimulation {
    override def InverterDelay: Int = 1
    override def AndGateDelay: Int = 3
    override def OrGateDelay: Int = 5
  }

  test("インバーター実行のテスト_信号を反転させる"){
    val sut = new BasicCircuitSimulation1
    val input,output = new sut.Wire
    val probe = new Probe
    //output.setProbe(probe)
    input.setSignal(false)
    //実行
    sut.inverter(input,output)
    sut.probe("inverter",output,probe)
    sut.run()
    //検証
    assert(probe.getSignal == true)
    assert(probe.getCurrentTime == 1)
  }

  test("Wireのテスト_実行後信号を変えた場合_outputに信号が送られる"){
    val sut = new BasicCircuitSimulation1
    val input,output = new sut.Wire
    val probe = new Probe
    //output.setProbe(probe)
    input.setSignal(false)
    sut.inverter(input,output)
    sut.probe("inverter",output,probe)
    sut.run()
    //実行
    input.setSignal(true)
    sut.run()
    //検証
    assert(probe.getSignal == false)
    assert(probe.getCurrentTime == 2)
  }


  test("ANDゲート実行のテスト_インプットがtrueとfalseの場合_falseを返す"){
    val sut = new BasicCircuitSimulation1
    val input1,input2,output = new sut.Wire
    val probe = new Probe
    //実行
    input1.setSignal(true)
    input2.setSignal(false)
    sut.andGate(input1,input2,output)
    sut.probe("output",output,probe)
    sut.run()
    //検証
    assert(probe.getSignal == false)
  }

  test("ANDゲート実行のテスト_インプットがtrueとtrueの場合_trueを返す"){
    val sut = new BasicCircuitSimulation1
    val input1,input2,output = new sut.Wire
    val probe = new Probe
    //実行
    input1.setSignal(true)
    input2.setSignal(true)
    sut.andGate(input1,input2,output)
    sut.probe("output",output,probe)
    sut.run()
    //検証
    assert(probe.getSignal == true)
  }

  test("ORゲート実行のテスト_インプットがtrueとfalseの場合_trueを返す"){
    val sut = new BasicCircuitSimulation1
    val input1,input2,output = new sut.Wire
    val probe = new Probe
    //実行
    input1.setSignal(true)
    input2.setSignal(false)
    sut.orGate(input1,input2,output)
    sut.probe("output",output,probe)
    sut.run()
    //検証
    assert(probe.getSignal == true)
  }

  test("ORゲート実行のテスト_インプットがfalseとfalseの場合_falseを返す"){
    val sut = new BasicCircuitSimulation1
    val input1,input2,output = new sut.Wire
    val probe = new Probe
    //実行
    input1.setSignal(false)
    input2.setSignal(false)
    sut.orGate(input1,input2,output)
    sut.probe("output",output,probe)
    sut.run()
    //検証
    assert(probe.getSignal == false)
  }
}