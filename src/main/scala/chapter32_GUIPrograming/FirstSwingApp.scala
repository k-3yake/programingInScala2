package chapter32_GUIPrograming

import scala.swing._

/**
 * Created by katsuki on 2014/09/23.
 */
object FirstSwingApp extends SimpleSwingApplication{
  override def top: Frame = new MainFrame(){
    title = "First Swing App"
    contents = new Button {
      text = "Click me"
    }
  }
}
