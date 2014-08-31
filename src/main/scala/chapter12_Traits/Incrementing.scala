package chapter12_Traits

/**
 * Created by katsuki on 2014/08/17.
 */
trait Incrementing extends IntQueue{
  abstract override def put(x: Int) { super.put(x + 1)}
}
