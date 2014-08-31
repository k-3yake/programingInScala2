package chapter15_CaseClassAndPatternMatch

/**
 * Created by katsuki on 2014/08/18.
 */
class PatternInForExpression {

}

object PatternInForExpression{
  def main(args: Array[String]) {
    val capitals = Map("Japan"->"Tokyo")
    for((country, city) <- capitals)
      println(country + "," + city)

    val results = List(Some("apple"), None, Some("orange"))
    for(Some(fruit) <- results)
      println(fruit)
  }
}
