import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    private String value;
    private List<Node> children;
    private Declaration declaration;

    public Node(String value, List<Node> children) {
        this.value = value;
        this.children = children;
        this.declaration = null;
    }

    public Node(String value) {
        this(value, new ArrayList<>());
    }

    public Node(String value, Node... children) {
        this(value, Arrays.asList(children));
    }

    public void setAsVarDeclaration(String name, String type){
        this.declaration = new Declaration(name, "var", type);
    }

    public void setAsFuncDeclaration(String name, String type){
        this.declaration = new Declaration(name, "func", type);
    }

    public void setAsClassDeclaration(String name){
        this.declaration = new Declaration(name, "class", "");
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public String getValue() {
        return value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public String getTree(Node node, String indent) {
        String ret = indent + "|--[" + node.value + "]\n";
        for (Node child : node.children) {
            ret += getTree(child, indent + "   ");
        }
        return ret;
    }

    public String getSymbolTable(Node node) {
        String ret = "";
        if (node.declaration != null)
            ret = node.declaration.toString() + "\n";
        for (Node child : node.children) {
            ret += getSymbolTable(child);
        }
        return ret;
    }

    @Override
    public String toString() {
        return "[" + this.value + "]";
    }
}