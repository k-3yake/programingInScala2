package chapter18_StatefulObject

/**
 * Created by katsuki on 2014/08/24.
 */
abstract class BasicCircuitSimulation extends Simulation{
  def InverterDelay: Int
  def AndGateDelay: Int
  def OrGateDelay: Int

  class Wire{
    private var signal = false
    private var actions: List[Action] = List.empty
    def getSignal = signal
    def setSignal(signal: Boolean){
      if(this.signal != signal){
        this.signal = signal
        actions foreach (_ ())
      }
    }
    def addAction(a: Action): Unit ={
      actions = a :: actions
      a()
    }
  }

  def inverter(input: Wire, output: Wire): Unit = {
    def inverterAction(): Unit = {
      val inputSig = input.getSignal
      afterDelay(InverterDelay){
        println("called inverter")
        output setSignal !inputSig
      }
    }
    input addAction inverterAction
  }

  def andGate(input1: Wire, input2: Wire, output: Wire): Unit ={
    def andGateAction(): Unit ={
      val inputSignal1 = input1.getSignal
      val inputSignal2 = input2.getSignal
      afterDelay(AndGateDelay){
        output setSignal (inputSignal1 && inputSignal2)
      }
    }
    input1 addAction andGateAction
    input2 addAction andGateAction
  }

  def orGate(input1: Wire, input2: Wire, output: Wire): Unit ={
    def orGateAction(): Unit ={
      val inputSignal1 = input1.getSignal
      val inputSignal2 = input2.getSignal
      afterDelay(OrGateDelay){
        output setSignal (inputSignal1 || inputSignal2)
      }
    }
    input1 addAction orGateAction
    input2 addAction orGateAction
  }

  def probe(name: String, wire: Wire, probe: Probe): Unit ={
    def probeAction(): Unit ={
      println(name + " " + currentTime + " newValue=" + wire.getSignal)
      probe.setSignal(wire.getSignal)
      probe.setCurrentTime(currentTime)
    }
    wire addAction probeAction
  }
}
