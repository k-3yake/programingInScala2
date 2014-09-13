package chapter27_ModularProgrammingUsingObject

/**
 * Created by katsuki on 2014/09/14.
 */
object SimpleDatabase extends DataBase{
  def allFood():List[Food] = List(Apple,Orange,Cream,Sugar)
  def allRecipes(): List[Recipe] = List(FruitsSalad)
  def foodNamed(name: String):Option[Food] = allFood().find(_.name == name)
  val fruits = FoodCategory("fruits",List(Apple,Orange))
  val misc = FoodCategory("misc",List(Cream,Sugar))
  def allCategories(): List[SimpleDatabase.FoodCategory] = List(fruits,misc)
}
