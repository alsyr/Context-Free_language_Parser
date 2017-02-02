/*
* Alik-Serguy Alphonsovich Rukubayihunga
* CS154-Formal Language & Computation
* MoWe 12:00-13:15 Spring 2015
*/
package cs154.ex5;

/**
 * @author AlSyR
 */
public class DemoParsers {

  public static Parser number = Combinators.regEx("[1-9][0-9]*");
  public static Parser name = Combinators.regEx("[a-zA-Z][a-zA-Z0-9]*");
  public static Parser boole = Combinators.regEx("true|false");
  public static Parser operator = Combinators.regEx("&&|\\|\\||\\+|\\*|!");

  //NAME | NUMBER | BOOLE
  public static Parser term = new Parser();

  static {
    term.setParser(
        Combinators.alt(
            name,
            Combinators.alt(
                number,
                boole)));
  }

  //TERM~(OPERATOR~TERM)+ | TERM
  public static Parser product = new Parser();

  static {
    product.setParser(
        Combinators.alt(
            Combinators.seq(
                term,
                Combinators.rep(
                    Combinators.seq(operator, term))
            ),
            term
        ));
  }

  public static void test(Parser p, String s) {
    System.out.println("s = " + s);
    Result tree = p.apply(new Result(s));
    System.out.println("tree = " + tree);
    System.out.println("pending = " + tree.pending());
  }

  public static void testDemoParsers() {

    String s = "21";
    test(DemoParsers.number, s);
    s = "grandad";
    test(DemoParsers.number, s); //should fail
    s = "alpha";
    test(DemoParsers.name, s);
    s = "Beta07aW";
    test(DemoParsers.name, s);
    s = "091139badf";
    test(DemoParsers.name, s); //should fail
    s = "true";
    test(DemoParsers.boole, s);
    s = "false";
    test(DemoParsers.boole, s);
    s = "kushmoneyking 123";
    test(DemoParsers.boole, s); //should fail
    s = "&&";
    test(DemoParsers.operator, s);
    s = "||";
    test(DemoParsers.operator, s);
    s = "+";
    test(DemoParsers.operator, s);
    s = "*";
    test(DemoParsers.operator, s);
    s = "!";
    test(DemoParsers.operator, s);
    s = "! ||";
    test(DemoParsers.operator, s); //should print only first <!>
    s = "false";
    test(DemoParsers.term, s);
    s = "1244326";
    test(DemoParsers.term, s);
    s = "hEllO312";
    test(DemoParsers.term, s);
    s = "tango666";
    test(DemoParsers.product, s);
    s = "Brend4K || true ! 423";
    test(DemoParsers.product, s);
    s = "42 Brend4K || true ! 423"; //should just print <42>
    test(DemoParsers.product, s);
  }

  public static void main(String args[]) {
    DemoParsers demo = new DemoParsers();
    demo.testDemoParsers();
  }
}
