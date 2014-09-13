package chapter24_Extractor

import org.scalatest.FunSuite

/**
 * Created by katsuki on 2014/09/12.
 */
class IsTomInDotComTest extends FunSuite {

  test("comのtomの判定のテスト_comのTomの場合_true"){
    assert(IsTomInDotCom.exec("tom@domain.com") == true)
  }

  test("comのtomの判定のテスト_comでないのtomの場合_false"){
    assert(IsTomInDotCom.exec("tom@domain.jp") == false)
  }

  test("comのtomの判定のテスト_comだがtomでない場合_false"){
    assert(IsTomInDotCom.exec("bob@domain.com") == false)
  }

}
