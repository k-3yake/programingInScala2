package chapter27_ModularProgrammingUsingObject

/**
 * Created by katsuki on 2014/09/14.
 */
object StudendDatabase extends DataBase{
  object FrozenFood extends Food("FrozenFood")
  override def allFood() = List(FrozenFood)
  object HeatItUp extends Recipe("HeatItUp",List(FrozenFood),"ting!")
  override def allRecipes() = List(HeatItUp)
  override def allCategories() = List(FoodCategory("edible",List(FrozenFood)))
}
