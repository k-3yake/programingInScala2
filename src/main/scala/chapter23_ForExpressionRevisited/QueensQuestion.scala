package chapter23_ForExpressionRevisited

class QueensQuestion {
  def queens(n: Int): List[List[(Int,Int)]] = {

    def placeQueens(k: Int): List[List[(Int,Int)]] = {
      if (k == 0)
        List(List())
      else {
        for{
          queens <- placeQueens(k -1);
          column <- 1 to n;
          queen = (k,column)
          if isSafety(queen,queens)
        } yield queen :: queens
      }
    }
    placeQueens(n)
  }

  def isSafety(queen :(Int,Int), others :List[(Int,Int)]):Boolean = {
    others forall (q => !inCheck(queen,q))
  }
  def inCheck(queen :(Int,Int),other :(Int,Int)) ={
    queen._1 == other._1 || queen._2 == other._2 || (queen._1 - other._1).abs == (queen._2 - other._2).abs
  }
}

object QueensQuestion {
  def apply() = new QueensQuestion
}