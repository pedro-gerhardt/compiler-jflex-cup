import java.io.*;

public class Main {
  public static void main(String[] argv) {
    /* Start the parser */
    try {
      parser p = new parser(new Lexer(new FileReader(argv[0])));
      Node result = (Node) p.parse().value;

      result.printTree(result, "");
      // System.out.println(result);
      
      System.out.println("Successful compilation!");      
    } catch (Exception e) {
      /* do cleanup here -- possibly rethrow e */
      e.printStackTrace();
    }
  }
}

