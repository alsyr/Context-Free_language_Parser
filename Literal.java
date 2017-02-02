/*
* Alik-Serguy Alphonsovich Rukubayihunga
* CS154-Formal Language & Computation
* MoWe 12:00-13:15 Spring 2015
*/
package cs154.ex5;

/**
 * @author AlSyR
 */
public class Literal extends Result {

  protected String token;

  @Override
  public String toString() {
    if (fail)
      return "fail";

    return "<" + token + ">";
  }
}
