package chapter19_TypeParameterization

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/27.
 */
class OutputChanelTest extends FunSuite {

  test("反変のテスト"){
    val anyRefVal: AnyRef = "anyRef"
    val chanel1 = new ContravarianceOutputChanel[String]
    chanel1.write("str")

    //コンパイルエラー
    //chanel1.write(anyRefVal)

    val chanel2 = new ContravarianceOutputChanel[AnyRef]
    chanel1.write("str")
    chanel2.write(anyRefVal)
  }

  test("共変のテスト"){
    val anyRefVal: AnyRef = "anyRef"
    val chanel1 = new ConvariantOutputChanel[String]
    chanel1.write("str")
    chanel1.write(anyRefVal)//こっちは共変OK
  }


}
