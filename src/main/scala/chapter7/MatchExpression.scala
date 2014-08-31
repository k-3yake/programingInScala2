package chapter7

/**
 * Created by katsuki on 2014/08/16.
 */
object MatchExpression {

  def matchFood(food: String) = {
    val friendFood = food match {
      case "salt" => "pepper"
      case "chips" => "salsa"
      case "eggs" => "bacon"
      case _ => "huh?"
    }
    friendFood
  }

  def main(args: Array[String]) {
    println(matchFood("salt"))
    println(matchFood("beef"))
  }
}
