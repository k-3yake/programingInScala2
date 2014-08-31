package chapter9_ControllAbstraction

/**
 * Created by katsuki on 2014/08/16.
 */
object A2_SimplifyClientCode {
  //  def containNeg(nums: List[Int]) ={
  //    var exists = false
  //    for(num <- nums)
  //      if (num < 0) exists = true
  //    exists
  //}
  def containNeg(nums: List[Int]) = nums.exists(_ < 0)

  def main(args: Array[String]) {
    println(containNeg(List(1,2,3)))
    println(containNeg(List(1,-1,3)))
  }
}
