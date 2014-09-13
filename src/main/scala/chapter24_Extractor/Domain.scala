package chapter24_Extractor

/**
 * Created by katsuki on 2014/09/12.
 */
object Domain {

  def unapplySeq(str: String): Option[Seq[String]] = {
    Some(str.split("\\.").reverse)
  }

}
