package chapter32_GUIPrograming

import sun.jvm.hotspot.ui.tree.SimpleTreeGroupNode

import scala.swing._
import scala.swing.event.EditDone

/**
 * Created by katsuki on 2014/09/25.
 */
object TempConverter extends SimpleSwingApplication{
  override def top = new MainFrame {
    title = "Celsius/Fahrenheit Converter"
    object celsius extends TextField { columns = 5 }
    object fahrenheit extends TextField { columns = 5 }
    contents = new FlowPanel {
      contents += celsius
      contents += new Label(" Celsius = ")
      contents += fahrenheit
      contents += new Label(" Fahrenheit")
      border = Swing.EmptyBorder(15,10,10,10)
    }
    listenTo(celsius,fahrenheit)
    reactions += {
      case EditDone(`fahrenheit`) =>
        val f = fahrenheit.text.toInt
        val c = (f - 32) * 5/9
        celsius.text = c.toString
      case EditDone(`celsius`) =>
        val c = celsius.text.toInt
        val f = c * 9/5 + 32
        fahrenheit.text = f.toString
    }
  }
}
