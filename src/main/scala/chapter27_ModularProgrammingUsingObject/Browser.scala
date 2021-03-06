package chapter27_ModularProgrammingUsingObject

/**
 * Created by katsuki on 2014/09/14.
 */
abstract class Browser {
  val database: DataBase

  def recipesUsing(food: Food): List[Recipe] = {
    database.allRecipes().filter(recipe => recipe.ingredient.contains(food))
  }
  def displayCategory(category: FoodCategory) = category.toString
}
