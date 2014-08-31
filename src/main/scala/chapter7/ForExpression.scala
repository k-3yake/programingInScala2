package chapter7

import java.io.File

import scala.io.Source

/**
 * Created by katsuki on 2014/08/16.
 */
object ForExpression {
  def hereFiles = new File(".").listFiles().toList

  def printFiles(): Unit = {
    for (
      file <- hereFiles
      if file.getName.endsWith("iml")
    ) println(file)
  }

  def fileLines(file: File) = Source.fromFile(file).getLines().toList

  def grep(pattern: String) = {
    val filesHere = hereFiles
    for (
      file <- filesHere
      if file.isFile;
      line <- fileLines(file)
      if line.trim.matches(pattern)
    ) println(file + ": " + line)
  }

  def hereDir = {
    for (
      file <- hereFiles
      if file.isDirectory
    ) yield file
  }

  def main(args: Array[String]) {
    printFiles
    grep(".*type.*")
    println(hereDir)
  }
}