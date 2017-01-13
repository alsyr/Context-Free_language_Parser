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
public class Combinators {
    
    // returns p1 | p2
    public static Parser alt(Parser p1, Parser p2) {
        Parser parser = new Parser();
        parser.setParser(
                result->{

                    if (result.fail) return result;
                    List<String> unseen = new ArrayList<>(result.unseen);
                    Choice answer = new Choice();
                    answer.choice = p1.apply(result);
                    if (answer.choice.fail)  {
                        result.unseen = new ArrayList<>(unseen);
                        answer.choice = p2.apply(result);
                    }
                    if (answer.choice.fail){
                        answer.fail = true;
//                        answer.choice.unseen = unseen;
                        return answer;
                    }

                    answer.unseen = result.unseen;
                    return answer;
                });
        return parser;
    }
    
    
    public static Parser seq(Parser p1, Parser p2) {
        Parser parser = new Parser();
        parser.setParser(
                result->{
                    
                    if (result.fail) return result; 
                    Concatenation answer = new Concatenation();
                    List<String> unseen = new ArrayList<String>(result.unseen);

                    answer.first = p1.apply(result);

                    if (answer.first.fail)  {
                        answer.fail = true;
                        answer.unseen = new ArrayList<>(unseen);
                        return answer;
                    }
                    
                    else{
                        result.unseen = answer.first.unseen;
                        answer.second = p2.apply(result);
                        if (answer.second.fail)  {
                            answer.unseen = new ArrayList<>(unseen);
                            answer.fail = true;
                            return answer;
                        }
                    }

                    answer.unseen = new ArrayList<>(result.unseen);
                    return answer;
                });
        return parser;
    }
    
    // returns p+
    public static Parser rep(Parser p) {
        Parser parser = new Parser();
        parser.setParser(
                result->{
                    
                    if (result.fail) return result;
                    
                    Iteration answer = new Iteration();
                    List<String> unseen = new ArrayList<String>(result.unseen);
                    
                    do
                    {
                        result = p.apply(result);
                        if(!result.fail){
                            unseen = new ArrayList<String>(result.unseen);
                            answer.base.add(result);
                        }
//                        else{
//                            //answer.fail = true;
//                            answer.unseen = new ArrayList<>(result.unseen);
//                            return answer;
//
//                        }
                    }while(!result.fail);
                    answer.unseen = new ArrayList<>(unseen);

                    return answer;
                });
        return parser;
    }
    
    // returns p?
    public static Parser opt(Parser p) {
        Parser parser = new Parser();
        parser.setParser(
                result->{
                    
                    //if (result.fail)return result;
                    Option answer = new Option();
                    List<String> unseen = new ArrayList<String>(result.unseen);
                    
                    answer.option = p.apply(result);
                    if(answer.option.fail){
                        if(answer.option.pending() == 0){
                            answer.unseen = new ArrayList<>(result.unseen);
                            return answer;
                        }
                        answer.fail = true;
                        answer.unseen = new ArrayList<>(unseen);
                        return answer;
                    }
                    answer.unseen = new ArrayList<>(result.unseen);
                    return answer;
                });
        return parser;
    }
    
    
    public static Parser regEx(String regex) {
        Parser parser = new Parser();
        parser.setParser(
                result->{
                    //if (result.fail)return result;
                    if(result.pending() == 0)
                    {
                        result.fail = true;
                        return result;
                    }
                    
                    Literal answer = new Literal();
                    answer.token = result.unseen.get(0);
                    
                    answer.unseen = result.unseen;
                    
                    if (answer.token.matches(regex)){
                        answer.unseen.remove(0);
                    }
                    else{
                        answer.fail=true;
                    }
                    return answer;
                });
        return parser;
    }
    
    // etc.
}
