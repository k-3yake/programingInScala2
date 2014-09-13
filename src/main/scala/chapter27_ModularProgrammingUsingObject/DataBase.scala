package chapter27_ModularProgrammingUsingObject

/**
 * Created by katsuki on 2014/09/14.
 */
abstract class DataBase extends FoodCategories{
  def allFood():List[Food]
  def allRecipes(): List[Recipe]
  def foodNamed(name: String):Option[Food] = allFood().find(_.name == name)
}
