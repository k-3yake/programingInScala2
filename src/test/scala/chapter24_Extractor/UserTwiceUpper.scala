package chapter24_Extractor

/**
 * Created by katsuki on 2014/09/12.
 */
object UserTwiceUpper {

  def exec(str: String): String = {
    str match {
      case Email(Twice(user @ UpperCase()),domain) => "domain=" + domain + ",userTwice=" + user
      case _ => "none"
    }
  }
}
