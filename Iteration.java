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
public class Iteration extends Result{
    
    protected List<Result> base;
    
    public Iteration()
    {
        base = new ArrayList<Result>();
    }
    
    
    
    @Override
    public String toString() {
//        if(this.fail && this.pending() != 0)
//            return super.toString();
        return "["   + "+ " + base.toString() + "]";
    }
}
