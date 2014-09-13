package chapter24_Extractor

/**
 * Created by katsuki on 2014/09/12.
 */
object Email {
  def unapply(str: String):Option[(String,String)] = {
    val parts = str.split("@")
    if(parts.length == 2) Some(parts(0),parts(1)) else None
  }
}
