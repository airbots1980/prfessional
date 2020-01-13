import java.util.List;

public class GenericTreeNode {

    List<GenericTreeNode> children;
    int value;

    public GenericTreeNode(List<GenericTreeNode> children, int val) {
        value = val;
        children = children;
    }
}
