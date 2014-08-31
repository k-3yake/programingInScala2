package chapter12_Traits

/**
 * Created by katsuki on 2014/08/17.
 */
trait Doubling extends IntQueue{
  abstract override def put(x: Int) { super.put(2 * x) }
}
