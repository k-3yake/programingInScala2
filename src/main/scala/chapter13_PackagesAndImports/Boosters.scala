package chapter13_PackagesAndImports

/**
 * Created by katsuki on 2014/08/17.
 */
package launch{
  class Booster3
}

package bobsrokets {
  package navigation{

  package launch{
      class Booster1
    }
    class MissionControl {
      val booster1 = new launch.Booster1
      val booster2 = new bobsrokets.launch.Booster2
      val booster3 = new chapter13_PackagesAndImports.launch.Booster3
    }
  }
  package launch{
    class Booster2
  }
}
