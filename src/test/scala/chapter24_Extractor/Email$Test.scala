package chapter24_Extractor

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/12.
 */
class EmailTest extends FunSuite {

  test("メール抽出子のテスト_メールアドレス形式の場合_ユーザとドメインに分ける"){
    val Email(user,domain) = "user@domain.co.jp"
    assert(user == "user")
    assert(domain == "domain.co.jp")
  }

  test("メール抽出子のテスト_メールアドレス形式で無い場合_エラーとなる") {
    intercept[MatchError] {
      val Email(user, domain) = "userdomain.co.jp"
    }
  }
}
