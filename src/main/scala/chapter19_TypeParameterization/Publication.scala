package chapter19_TypeParameterization

/**
 * Created by katsuki on 2014/08/27.
 */
class Publication(val title: String)
class Book(title: String) extends Publication(title)

object Library {
  val books: Set[Book] = Set[Book]( new Book("book1"),new Book("book2") )
  def bookList(info: Book => AnyRef) = {
    for(book <- books) yield info(book)
  }
}

