package chapter24_Extractor

/**
 * Created by katsuki on 2014/09/12.
 */
object Twice {

  def unapply(str :String): Option[String] = {
    val length = str.length
    val half = str.substring(0,length/2)
    if(half == str.substring(length/2)) Some(half) else None
  }
}
