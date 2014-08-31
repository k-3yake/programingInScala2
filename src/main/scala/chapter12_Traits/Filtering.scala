package chapter12_Traits

/**
 * Created by katsuki on 2014/08/17.
 */
trait Filtering extends IntQueue{
  abstract override def put(x: Int) = {
    if(x >= 0) super.put(x)
  }
}
