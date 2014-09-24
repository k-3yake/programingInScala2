package chapter32_GUIPrograming

import scala.swing._
import scala.swing.event.ButtonClicked

/**
 * Created by katsuki on 2014/09/23.
 */
object FirstSwingApp extends SimpleSwingApplication{
  override def top: Frame = new MainFrame(){
    title = "First Swing App"
    val button = new Button {
      text = "Click me"
    }
    val label = new Label {
      text = "No button clicks registered"
    }
    contents = new BoxPanel(Orientation.Vertical){
      contents += button
      contents += label
      border = Swing.EmptyBorder(30,30,10,30)
    }
    listenTo(button)
    var nClicks = 0
    reactions += {
      case ButtonClicked(sourceButton) =>
        nClicks += 1
        label.text = "Number of button clicks: " + nClicks
    }
  }
}
