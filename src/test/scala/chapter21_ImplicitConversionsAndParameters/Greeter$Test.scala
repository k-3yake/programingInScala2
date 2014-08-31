package chapter21_ImplicitConversionsAndParameters

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/31.
 */
class GreeterTest extends FunSuite {

  test("暗黙パラメータのテスト"){
    implicit val prompt = new PreferredPrompt("Yes,master>")
    implicit val drink = new PreferredDrink("coke")
    assert(Greeter.greet("joe") == ("Welcome joe.Already coke","Yes,master>"))
  }

}
