package chapter24_Extractor

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/12.
 */
class UserTwiceUpperTest extends FunSuite {

  test("値の抽出分割テスト_ユーザが大文字で同じ文字の繰り返しの場合_ドメインとユーザの繰り返し文字を表す文字を返す"){
    val result = UserTwiceUpper.exec("TESTTEST@domain.co.jp")
    assert(result == "domain=domain.co.jp,userTwice=TEST")
  }

  test("値の抽出分割テスト_ユーザが小文字の繰り返しの場合_noneを返す"){
    val result = UserTwiceUpper.exec("testtest@domain.co.jp")
    assert(result == "none")
  }

  test("値の抽出分割テスト_ユーザが大文字で繰り返しでない場合_noneを返す"){
    val result = UserTwiceUpper.exec("TESTTES@domain.co.jp")
    assert(result == "none")
  }

  test("値の抽出分割テスト_ユーザ繰り返しだが大文字と小文字の場合_noneを返す"){
    val result = UserTwiceUpper.exec("TESTTEsT@domain.co.jp")
    assert(result == "none")
  }
}
