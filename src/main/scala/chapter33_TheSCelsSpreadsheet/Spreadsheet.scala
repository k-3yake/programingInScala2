package chapter33_TheSCelsSpreadsheet

import scala.swing._
import scala.swing.event.TableUpdated

/**
 * Created by katsuki on 2014/09/25.
 */
class Spreadsheet(val height: Int, val width: Int) extends ScrollPane{
  val cellModel = new Model(height,width)
  import cellModel._

  val table = new Table(height,width){
    rowHeight = 25
    autoResizeMode = Table.AutoResizeMode.Off
    showGrid = true
    gridColor = new Color(150,150,150)
    reactions += {
      case TableUpdated(table,rows,column) =>
        for(row <- rows) cells(row)(column).formula = FormulaParsers.parse(userData(row,column))
    }

    override def rendererComponent(isSelected: Boolean,focused: Boolean,row: Int,column: Int): Component = {
      if(hasFocus) new TextField(userData(row,column))
      else new Label(cells(row)(column).toString){
        xAlignment = Alignment.Right
      }
    }

    def userData(row: Int ,column: Int): String ={
      val v = this(row,column)
      if (v == null) "" else v.toString
    }
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