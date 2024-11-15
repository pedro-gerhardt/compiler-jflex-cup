import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    // <name, type>
    private Map<String, String> symbolTable;
    private int tempCount; 

    public SymbolTable() {
        symbolTable = new HashMap<>();
        tempCount = 1;
    }

    public String getTempVar(String type) {
        String tempVar = "t" + tempCount++;
        symbolTable.put(tempVar, type);
        return tempVar;
    }

    public void addVariable(String name, String type) {
        symbolTable.put(name, type);
    }

    public void addFunction(String name, String type) {
        symbolTable.put(name, "function, " + type);
    }

    public void addClass(String name) {
        symbolTable.put(name, "class");
    }

    public String getVariable(String name) {
        return symbolTable.get(name);
    }

    public void printTable() {
        symbolTable.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public String getTable() {
        StringBuilder sb = new StringBuilder();
        symbolTable.forEach((key, value) -> sb.append(key + ": " + value + "\n"));
        return sb.toString();
    } 
}
