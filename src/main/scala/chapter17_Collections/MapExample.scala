package chapter17_Collections
import scala.collection.mutable.Map
/**
 * Created by katsuki on 2014/08/23.
 */
class MapExample {

  def countWord(str: String) = {
    val result = Map.empty[String,Int]
    for (rawWord <- str.split("[ ,!.]+")){
      val word = rawWord.toLowerCase
      val oldCount =
        if (result.contains(word)) result(word)
        else 0
      result += (word -> (oldCount + 1))
    }
    result
  }
}
