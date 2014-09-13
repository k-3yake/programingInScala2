package chapter27_ModularProgrammingUsingObject

import chapter27_ModularProgrammingUsingObject.SimpleDatabase.FoodCategory

/**
 * Created by katsuki on 2014/09/14.
 */
object SimpleBrowser {
  def recipesUsing(food: Food): List[Recipe] = {
    SimpleDatabase.allRecipes().filter(recipe => recipe.ingredient.contains(food))
  }
  def displayCategory(category: FoodCategory) = category.toString
}
