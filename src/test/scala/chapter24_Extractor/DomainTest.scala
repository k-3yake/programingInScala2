package chapter24_Extractor

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/12.
 */
class DomainTest extends FunSuite {

  test("ドメイン分割のテスト_要素が複数の場合_その要素を返す"){
    val Domain(domains @ _*) = "domain.co.jp"
    assert(domains.toList == List("jp","co","domain"))
  }

  test("ドメイン分割のテスト_要素が1つの場合_その要素を返す"){
    val Domain(domains @ _*) = "domain"
    assert(domains.toList == List("domain"))
  }

  test("ドメイン分割のテスト_要素が0の場合_空のリストを返す"){
    val Domain(domains @ _*) = ""
    assert(domains.toList == List(""))
  }

}
