package chapter33_TheSCelsSpreadsheet

import scala.swing._

/**
 * Created by katsuki on 2014/09/25.
 */
class Spreadsheet(val height: Int, val width: Int) extends ScrollPane{
  val table = new Table(height,width){
    rowHeight = 25
    autoResizeMode = Table.AutoResizeMode.Off
    showGrid = true
    gridColor = new Color(150,150,150)
  }
  val rowHeader = new ListView(){
    fixedCellWidth = 30
    fixedCellHeight = table.rowHeight
  }
  viewportView = table
  rowHeaderView = rowHeader
}

object Spreadsheet extends SimpleSwingApplication {
  override def top = new MainFrame(){
    title = "SpreadSheet"
    contents = new Spreadsheet(100,26)
  }
}