package chapter27_ModularProgrammingUsingObject

/**
 * Created by katsuki on 2014/09/14.
 */
object GetApples {

  def exec(dbName: String):List[Recipe] = {
    val db =
      if(dbName == "student") StudentDatabase
      else SimpleDatabase
    val browser = new Browser { val database = db }
    browser.recipesUsing(Apple)
  }


}
