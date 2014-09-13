package chapter27_ModularProgrammingUsingObject

/**
 * Created by katsuki on 2014/09/14.
 */
trait FoodCategories {
  def allCategories(): List[FoodCategory]
}
case class FoodCategory(name: String, foods: List[Food])
