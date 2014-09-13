package chapter27_ModularProgrammingUsingObject

/**
 * Created by katsuki on 2014/09/14.
 */
abstract class DataBase {
  def allFood():List[Food]
  def allRecipes(): List[Recipe]
  case class FoodCategory(name: String, foods: List[Food])
  def allCategories(): List[FoodCategory]
}
