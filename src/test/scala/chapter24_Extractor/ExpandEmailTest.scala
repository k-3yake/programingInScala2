package chapter24_Extractor

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/12.
 */
class ExpandEmailTest extends FunSuite {

  test("メールアドレス分割のテスト_メールアドレス形式の場合_固定要素のユーザ名とドメインの配列を返す"){
    val ExpandEmail(name,domains @ _*) = "tom@domain.co.jp"
    assert(name == "tom")
    assert(domains.toList == List("jp","co","domain"))
  }

}
