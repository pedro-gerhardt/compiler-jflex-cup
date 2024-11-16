import java.io.*;

public class Main {
    public static void main(String[] argv) {
        try {
            if (argv.length != 4) {
                System.err.println("Wrong number of arguments!");
                return;
            }
            String code_in = argv[0], 
                ast_out = argv[1], 
                sym_tab_out = argv[2],
                int_code_out = argv[3];
                
            parser p = new parser(new Lexer(new FileReader(code_in)));
            Node result = (Node) p.parse().value;

            String tree = result.getTree(result, "");
            writeStringToFile(tree, ast_out);
            System.out.println("Abstract Syntactic Tree: ");
            System.out.println(tree);

            System.out.println("\n\n\n");

            String symTab = p.symbolTable.getTable();
            writeStringToFile(symTab, sym_tab_out);
            System.out.println("Symbol Table: ");
            System.out.println(symTab);
            
            System.out.println("\n\n\n");

            String tacs = result.code;
            writeStringToFile(tacs, int_code_out);
            System.out.println("TACs: ");
            System.out.println(tacs);

            System.out.println("Successful compilation!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeStringToFile(String content, String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
