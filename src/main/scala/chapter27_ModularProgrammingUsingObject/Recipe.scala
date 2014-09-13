package chapter27_ModularProgrammingUsingObject

/**
 * Created by katsuki on 2014/09/14.
 */
class Recipe(val name: String, val ingredient: List[Food], val instructions: String) {

  override def toString = name

}
