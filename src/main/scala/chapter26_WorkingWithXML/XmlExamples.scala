package chapter26_WorkingWithXML

import scala.xml.Elem

/**
 * Created by katsuki on 2014/09/13.
 */
class XmlExamples {
  val aTag = <a> </a>
  val abcTag = <a><b><c>TheC</c>TheB</b></a>

  def toATag(str: String):Elem = {
    <a>{str}</a>
  }

  def toXml(user: User) = <user><name>{user.name}</name><age>{user.age}</age></user>

  def fromXml(xml: Elem):User = {
    new User((xml \ "name").text,(xml \ "age").text.toInt)
  }
}
class User(val name: String,val age: Integer)