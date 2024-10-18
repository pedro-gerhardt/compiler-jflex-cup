import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public void printTree(Node node, String indent) {
        System.out.println(indent + "|--[" + node.value + "]");
        for (Node child : node.children) {
            printTree(child, indent + "   ");
        }
    }

    @Override
    public String toString() {
        return "[" + this.value + "]";
    }
}