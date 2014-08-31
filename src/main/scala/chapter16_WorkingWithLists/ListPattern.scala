package chapter16_WorkingWithLists

/**
 * Created by katsuki on 2014/08/19.
 */
object ListPattern {
  def isort(list: List[Int]):List[Int] = list match {
    case List() => List()
    case head::restList => insert(head,isort(restList))
  }

  def insert(insertNum: Int,inserted: List[Int]):List[Int] = inserted match {
    case List() => List(insertNum)
    case head::restList => if(insertNum < head) insertNum::inserted
                           else head::(insert(insertNum,restList))
  }
}
