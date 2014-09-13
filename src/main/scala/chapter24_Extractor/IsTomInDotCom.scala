package chapter24_Extractor

/**
 * Created by katsuki on 2014/09/12.
 */
object IsTomInDotCom {

  def exec(str: String): Boolean = {
    str match {
      case Email("tom",Domain("com",_*)) => true
      case _ => false
    }
  }

}
