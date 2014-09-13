package chapter26_WorkingWithXML

import org.scalatest.FunSuite

import scala.xml.Elem
import scala.xml.NodeSeq.Empty

/**
 * Created by katsuki on 2014/09/13.
 */
class XmlExamplesTest extends FunSuite {

  test("xmlの変数"){
    assert(new XmlExamples().aTag.toString() == "<a> </a>")
  }

  test("atagへの変換"){
    val aTag = new XmlExamples().toATag("hello")
    assert(aTag.text == "hello")
    assert(aTag.label == "a")
    assert(aTag.toString() == "<a>hello</a>")
  }

  test("サブ要素の抽出") {
    val tag = new XmlExamples().abcTag \ "b"
    assert(tag.head.text == "TheCTheB")
  }

  test("サブ要素の抽出_2階層以下は取得出来ない") {
    val tag = new XmlExamples().abcTag \ "c"
    assert(tag == Empty)
  }

  test("ディープサーチ"){
    val cTag = new XmlExamples().abcTag \\ "c"
    assert(cTag.text == "TheC")
  }

  test("XMLへの変換"){
    val user = new User("bob",30)
    val xml = new XmlExamples().toXml(user)
    assert(xml.toString() == "<user><name>bob</name><age>30</age></user>")
  }

  test("XMLからの変換"){
    val user = new XmlExamples().fromXml(<user><name>bob</name><age>30</age></user>)
    assert(user.name == "bob")
    assert(user.age == 30)
  }
}