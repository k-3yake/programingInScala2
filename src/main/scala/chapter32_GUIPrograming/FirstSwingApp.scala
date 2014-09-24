package chapter32_GUIPrograming

import scala.swing._

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
  }
}
