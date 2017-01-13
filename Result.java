/*
* Alik-Serguy Alphonsovich Rukubayihunga
* CS154-Formal Language & Computation
* MoWe 12:00-13:15 Spring 2015
*/
package cs154.ex5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AlSyR
 */
public class Result {
    
    protected List<String> unseen; // unprocessed tokens
    protected boolean fail; // parser error
    
    public Result(String s) {
        this(s, "\\s+");
    }
    
    public Result() {
        unseen = new ArrayList<String>();
        fail = false;
    }
    
    //# unseen tokens
    public int pending() {
        return unseen.size();
    }
    
    public Result(String s, String regEx) {
        fail = false;
        String[] a = s.split(regEx);
        unseen = new ArrayList<String>();
        for(int i = 0; i < a.length; i++) {
            unseen.add(a[i]);
        }
    }
    
    public String toString() {
        return "[fail = " + fail + "; unseen = " + unseen + "]";
    }
}
