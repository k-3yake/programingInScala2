package chapter27_ModularProgrammingUsingObject

/**
 * Created by katsuki on 2014/09/14.
 */
object SimpleDatabase {
  object Apple extends Food("Apple")
  object Orange extends Food("Orange")
  object Cream extends Food("Cream")
  object Sugar extends Food("Sugar")
  object FruitsSalad extends Recipe("FruitsSalad",List(Apple,Orange,Cream,Sugar),"混ぜる")
  case class FoodCategory(name: String, foods: List[Food])
  val fruits = FoodCategory("fruits",List(Apple,Orange))
  val misc = FoodCategory("misc",List(Cream,Sugar))
  var categories = List(fruits,misc)

  def allFood():List[Food] = List(Apple,Orange,Cream,Sugar)
  def allRecipes(): List[Recipe] = List(FruitsSalad)
}
