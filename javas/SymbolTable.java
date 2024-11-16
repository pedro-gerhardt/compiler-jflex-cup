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

    public void addConstant(String name, String type) {
        symbolTable.put(name, "constant, " + type);
    }

    public void addClass(String name) {
        symbolTable.put(name, "class");
    }

    public String getSymbolType(String name) throws Exception {
        String type = symbolTable.get(name);
        if (type == null)
            throw new Exception("Variable " + name + " is undeclared!");
        return type;
    }

    public boolean existVariable(String name) throws Exception {
        if (symbolTable.containsKey(name))
            return true;
        throw new Exception("Variable " + name + " is undeclared!");
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
