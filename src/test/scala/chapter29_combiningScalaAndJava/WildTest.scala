package chapter29_combiningScalaAndJava

import org.scalatest.FunSuite
import java.util.Vector

/**
 * Created by katsuki on 2014/09/15.
 */
class WildTest extends FunSuite{

  test("scalaからジェネリクスにwildを使用したjavaへのアクセスのテスト"){
    val contents = (new Wild).contents()
    //コップ本の通りなら存在型が返るのでこのテストは失敗するはずだが成功する。仕様が変わった？
    assert(contents.getClass() == new Vector().getClass)
  }

}
