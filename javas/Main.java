import java.io.*;

public class Main {
    public static void main(String[] argv) {
        try {
            String code_in = argv[0], 
                ast_out = argv[1], 
                sym_tab_out = argv[2];
                
            parser p = new parser(new Lexer(new FileReader(code_in)));
            Node result = (Node) p.parse().value;

            String tree = result.getTree(result, "");
            writeStringToFile(tree, ast_out);

            String symTab = p.symbolTable.getTable();
            writeStringToFile(symTab, sym_tab_out);
            
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
