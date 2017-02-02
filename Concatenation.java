/*
* Alik-Serguy Alphonsovich Rukubayihunga
* CS154-Formal Language & Computation
* MoWe 12:00-13:15 Spring 2015
*/
package cs154.ex5;

/**
 * @author AlSyR
 */
public class Concatenation extends Result {

  protected Result first, second;

  @Override
  public String toString() {
//        if(first.fail || second.fail)
//            return super.toString();
    return "[" + first.toString() + " ~ " + second.toString() + "]";
  }
}
