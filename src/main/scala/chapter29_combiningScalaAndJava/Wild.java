package chapter29_combiningScalaAndJava;

import java.util.Collection;
import java.util.Vector;

/**
 * Created by katsuki on 2014/09/15.
 */
public class Wild {
    Collection<?> contents() {
        Collection<String> stuff = new Vector<>();
        stuff.add("a");
        stuff.add("b");
        stuff.add("see");
        return stuff;
    }
}
