package chapter18_StatefulObject
import scala.collection.mutable

/**
 * Created by katsuki on 2014/08/24.
 */
abstract class Simulation {
  type Action = () => Unit
  case class WorkItem(time: Int, action: Action)
  private var currTime = 0
  def currentTime = this.currTime
  private var agenda = List[WorkItem]()

  private def insert(ag: List[WorkItem],item: WorkItem):List[WorkItem] = {
    if(ag.isEmpty || item.time < ag.head.time) item :: ag
    else ag.head :: insert(ag.tail,item)
  }

//  def afterDelay(delay: Int)(block: Action): Unit ={
//    agenda = insert(agenda,new WorkItem(delay,block))
//  }

  def afterDelay(delay: Int)(block: => Unit): Unit ={
    agenda = insert(agenda,new WorkItem(currentTime + delay,() => block))
  }

  private[chapter18_StatefulObject] def next(): Unit ={
    (agenda: @unchecked) match {
      case item :: rest =>
        agenda = rest
        currTime = item.time
        item.action()
    }
  }

  def run(): Unit ={
    while(!agenda.isEmpty) next()
  }

}
