package chapter20_AbstractMember

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/08/30.
 */
class CurrencyTest extends FunSuite {

  test("ドルの文字列表現のテスト"){
    val dollar = US.make(1001)
    assert(dollar.toString == "10.01 USD")
  }

  test("円の文字列表現のテスト"){
    val yen = Japan.make(1001)
    assert(yen.toString == "1001 JPY")
  }

  test("ユーロの文字列表現のテスト"){
    val euro = Europe.make(1001)
    assert(euro.toString == "10.01 EUR")
  }

  test("加算のテスト"){
    val dollar100 = US.make(100)
    //val dollar150 = dollar100 + Europe.make(50) コンパイルエラー
    assert((dollar100 + US.make(1)).toString() == "1.01 USD")
  }

  test("乗算のテスト"){
    assert((US.make(100) * 2).toString() == "2.00 USD")
  }

  test("乗算のテスト_少数点以下の値が出る場合_小数点以下は切り捨てられる"){
    assert((US.make(1) * 1.9).toString() == "0.01 USD")
  }

  test("通貨換算のテスト_100ドルを円に換算(レート:1$121.1yen)した場合"){
    assert((Japan.Yen from US.Dollar * 100.0).toString() == "12110 JPY")
  }
}