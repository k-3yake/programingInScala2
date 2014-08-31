package chapter7

/**
 * Created by katsuki on 2014/08/16.
 */
object MultiplicationOrderProcessing {

  def printMultiTable {
    var i = 1
    //iのみスコープに入っている
    while (i <= 10){
      var j = 1
      //iとjがスコープに入っている
      while(j <= 10){
        val prod = (i * j).toString
        //i,j,prodがスコープに入っている
        var k = prod.length
        //i,j,prod,kがスコープに入っている
        while(k < 4) {
          print(" ")
          k += 1
        }
        print(prod)
        j += 1
      }
      //i,jがスコープに入っている。prod,kはスコープから外れている。
      println()
      i += 1
    }
    //iがスコープに入っている。j,prod,kはスコープから外れている。
  }

  def main(args: Array[String]) {
    printMultiTable
  }
}
