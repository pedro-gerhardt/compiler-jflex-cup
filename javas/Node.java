import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    private String value;
    private List<Node> children;

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

    @Override
    public String toString() {
        return "[" + this.value + "]";
    }
}