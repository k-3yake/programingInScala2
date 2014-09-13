package chapter23_ForExpressionRevisited


class SupportForExpression[A] {

  def map[B](f: A => B):SupportForExpression[B] = {
    null
  }
  def flatMap[B](f: A => SupportForExpression[B]):SupportForExpression[B] = {
    null
  }
  def filter(p: A => Boolean): SupportForExpression[A] = {
    null
  }
}

