package chapter9_ControllAbstraction

import java.io.File

/**
 * Created by katsuki on 2014/08/16.
 */
object A1_RemoveDupulicateCode {

}

object FileMatcher {
  private def filesHere = (new File(".")).listFiles();
//  def filesEnding (query: String) = {
//    for (file <- filesHere; if file.getName.endsWith(query))
//    yield file
//    filesMatching(query, _.endsWith(_))
//  }
//  def filesContaining (query: String) = {
//    for (file <- filesHere; if file.getName.matches(query))
//    yield file
//    filesMatching(query, _.matches(_))
//  }
  def filesEnding(query: String) = filesMatching(query, _.endsWith(_))
  def filesContaining(query: String) = filesMatching(query, _.matches(_))
  def filesMatching(query: String, matcher: (String, String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName,query))
      yield file
  }
}