package chapter24_Extractor

/**
 * Created by katsuki on 2014/09/12.
 */
object ExpandEmail {

  def unapplySeq(email: String): Option[(String,Seq[String])] = {
    email match {
      case Email(user, Domain(domains @ _*)) => Some(user, domains)
      case _ => None
    }
  }
}
