/*
* Alik-Serguy Alphonsovich Rukubayihunga
* CS154-Formal Language & Computation
* MoWe 12:00-13:15 Spring 2015
*/
package cs154.ex5;

import java.util.function.UnaryOperator;

/**
 *
 * @author AlSyR
 */
public class Parser implements UnaryOperator<Result>{
    
    private UnaryOperator<Result> parser;
    
    public void setParser(UnaryOperator<Result> theParser){
        parser = theParser;
    }
    
    public UnaryOperator<Result> getParser(){
        return parser;
    }
    
    @Override
    public Result apply(Result r) {
        return parser.apply(r);
    }
    
}
