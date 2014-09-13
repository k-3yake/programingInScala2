package chapter27_ModularProgrammingUsingObject


/**
 * Created by katsuki on 2014/09/14.
 */
trait SimpleFood {
  object Pear extends Food("Pear")
  def allFood():List[Food] = List(Apple,Orange,Cream,Sugar,Pear)
  val fruits = FoodCategory("fruits",List(Apple,Orange))
  val misc = FoodCategory("misc",List(Cream,Sugar))
  def allCategories() = List(fruits,misc)
}
