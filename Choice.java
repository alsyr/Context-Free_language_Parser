/*
* Alik-Serguy Alphonsovich Rukubayihunga
* CS154-Formal Language & Computation
* MoWe 12:00-13:15 Spring 2015
*/
package cs154.ex5;

/**
 * @author AlSyR
 */
public class Choice extends Result {

  protected Result choice;

  @Override
  public String toString() {
    if (this.fail)
      return super.toString();
    return "[" + " | " + choice.toString() + "]";
  }
}
