package chapter24_Extractor

/**
 * Created by katsuki on 2014/09/12.
 */
object UpperCase {

  def unapply(str: String): Boolean = {
    str.toUpperCase == str
  }

}
