package chapter23_ForExpressionRevisited

/**
 * Created by katsuki on 2014/09/09.
 */
case class Book(title :String, authors :String*)

object Books {
  val books :List[Book] =
    List(
      Book("Structure and ・・・","Abe Har","Sus Ger"),
      Book("Principles of ・・・","Aho Alf","Ull Jef"),
      Book("Programing    ・・・","Wir Nik"),
      Book("Elements      ・・・","Ull Jef"),
      Book("The Java      ・・・","Joy Bil","Ste Guy","Bra Gil")
    )

  def twoBooksAuthors(): List[String] ={
    val authors =
      for(book1 <- books; book2 <- books if book1 != book2;
        a1 <- book1.authors; a2 <- book2.authors if a1 == a2) yield a1
    removeDuplicate(authors)
  }

  def removeDuplicate(arg :List[String]):List[String]={
    if(arg.isEmpty) arg
    else
      arg.head :: removeDuplicate( arg.tail filter (x => arg.head != x)  )
  }
}