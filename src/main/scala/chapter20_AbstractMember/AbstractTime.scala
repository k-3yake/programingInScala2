package chapter20_AbstractMember

/**
 * Created by katsuki on 2014/08/29.
 */
trait AbstractTime {
  var hour: Int
  var minute: Int
}

object Time{
  def apply(): AbstractTime = {
    new AbstractTime {
      override var hour: Int = 1
      override var minute: Int = 10
    }
  }
}



