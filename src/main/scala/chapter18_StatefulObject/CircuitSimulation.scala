package chapter18_StatefulObject

/**
 * Created by katsuki on 2014/08/25.
 */
abstract class CircuitSimulation extends BasicCircuitSimulation{

  def halfAdder(input1: Wire, input2: Wire, sum: Wire, carry: Wire): Unit ={
    val orToAnd,inverterToAnd = new Wire
    orGate(input1,input2,orToAnd)
    andGate(input1,input2,carry)
    inverter(carry,inverterToAnd)
    andGate(orToAnd,inverterToAnd,sum)
  }
}
