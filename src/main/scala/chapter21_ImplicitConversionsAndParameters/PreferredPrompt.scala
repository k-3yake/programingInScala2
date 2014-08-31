package chapter21_ImplicitConversionsAndParameters

/**
 * Created by katsuki on 2014/08/31.
 */
class PreferredPrompt(val preference: String) {
  override def toString() =  preference
}

class PreferredDrink(val drink: String){
  override def toString()={   drink  }
}

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt,drink: PreferredDrink) = {
    ("Welcome " + name + ".Already " + drink,prompt.toString())
  }
}
