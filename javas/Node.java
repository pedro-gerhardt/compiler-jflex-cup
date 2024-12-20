import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    public String value;
    public List<Node> children;
    // TAC info
    public String code = "";
    public String place = "";
    public String labelTrue = "";
    public String labelFalse = "";

    public Node(String value, List<Node> children) {
        this.value = value;
        this.children = children;
    }

    public Node(String value) {
        this(value, new ArrayList<>());
    }

    public Node(String value, Node... children) {
        this(value, Arrays.asList(children));
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

    public void copyTACInfo(Node node) {
        this.code = node.code;
        this.place = node.place;
    } 

    @Override
    public String toString() {
        return "[" + this.value + "]";
    }
}