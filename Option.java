/*
 * Alik-Serguy Alphonsovich Rukubayihunga
 * CS154-Formal Language & Computation
 * MoWe 12:00-13:15 Spring 2015
 */
package cs154.ex5;

/**
 *
 * @author AlSyR
 */
public class Option extends Result{
    
    protected Result option;
    
    @Override
    public String toString() {
        if(option.fail)
            return super.toString();
        return "[" + "? " + option.toString() + "]";
    }    
}
