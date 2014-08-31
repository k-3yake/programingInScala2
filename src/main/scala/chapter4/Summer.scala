package chapter4

import ChecksumAccumulator.calculate


/**
 * Created by katsuki on 2014/08/16.
 */
object Summer {
  def main(args: Array[String]) {
    for (arg <- args)
      println(arg + ":" + calculate(arg))
  }
}
