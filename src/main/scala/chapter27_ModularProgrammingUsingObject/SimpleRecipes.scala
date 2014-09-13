package chapter27_ModularProgrammingUsingObject

/**
 * Created by katsuki on 2014/09/14.
 */
trait SimpleRecipes {
  this: SimpleFood => //自分型の指定。実行時のthisはSimpleFoodをミックスインしなければならない。これによりSimpleFood.Pearへの参照が出来る。
  object FruitsSalad extends Recipe("FruitsSalad",List(Apple,Orange,Cream,Sugar),"混ぜる")
  object SuitePear extends Recipe("SuitePear",List(Sugar,Pear),"混ぜる")
  def allRecipes(): List[Recipe] = List(FruitsSalad,SuitePear)
}
