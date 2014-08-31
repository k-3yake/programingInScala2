package chapter18_StatefulObject

/**
 * Created by katsuki on 2014/08/24.
 */
class Probe {
  private var signal:Option[Boolean] = null
  private var currentTime:Option[Int] = null
  def getSignal = signal.get
  def setSignal(sig: Boolean){this.signal = Option(sig)}
  def getCurrentTime = currentTime.get
  def setCurrentTime(curTime: Int) = this.currentTime = Option(curTime)


}
