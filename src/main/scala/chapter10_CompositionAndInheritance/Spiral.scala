package chapter10_CompositionAndInheritance

/**
 * Created by katsuki on 2014/08/17.
 */
import Element.elem
object Spiral {
  val space = elem(" ")
  val corner = elem("+")
  val Right = 0
  val Up = 1
  val Left = 2
  val Down = 3
  def spiral (nEdge: Int, direction: Int):Element = {
    if(nEdge == 1)
      elem("+")
    else{
      val spElem = spiral(nEdge - 1, (direction + 3) % 4)
      println(spElem)
      println()
      def verticalBar = elem('|', 1, spElem.height)
      def horizontalBar = elem('-', spElem.width, 1)
      if (direction == Right)
        (corner beside horizontalBar) above (spElem beside space)
      else if (direction == Up)
        (spElem above space) beside (corner above verticalBar)
      else if (direction == Left)
        (space beside spElem) above (horizontalBar beside corner)
      else if (direction == Down)
        (verticalBar above corner) beside (space above spElem)
      else
        throw new IllegalArgumentException("direction=" + direction)
    }
  }

  def main(args: Array[String]) {
    println(spiral(17,0))
  }
}