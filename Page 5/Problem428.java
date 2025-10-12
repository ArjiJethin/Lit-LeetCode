import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class Problem428 {
    public static void main(String[] args) {
        // Example usage
        Node root = new Node(1, Arrays.asList(new Node(2), new Node(3, Arrays.asList(new Node(4)))));
        Codec codec = new Codec();
        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);
        Node deserializedRoot = codec.deserialize(serialized);
        System.out.println("Deserialized root value: " + deserializedRoot.val); // Expected output: 1
    }
}

class Codec {

    private static final String SPLITER = ",";
    private static final String NULL_NODE = "#";

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    // pre-order traversal
    private void buildString(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_NODE).append(SPLITER).append(0).append(SPLITER); // size=0
        } else {
            sb.append(node.val).append(SPLITER).append(node.children.size()).append(SPLITER);
            for (Node child : node.children) {
                buildString(child, sb);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        LinkedList<String> nodesList = new LinkedList<>();
        nodesList.addAll(Arrays.asList(data.split(SPLITER)));
        return buildTree(nodesList);
    }

    private Node buildTree(LinkedList<String> nodes) {
        // @note: key is here, just keep popping the 1st as root of current sub-tree
        String val = nodes.removeFirst();

        if (val.equals(NULL_NODE)) {
            return null;
        } else {
            Node node = new Node();
            node.val = Integer.valueOf(val);
            int size = Integer.valueOf(nodes.removeFirst()); // to get children size

            node.children = new ArrayList<>(size);
            for (int i = 0; i < size; ++i) {
                node.children.add(buildTree(nodes));
            }

            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

class Node {
    public int val;
    public List<Node> children;

    public Node() {
        this.children = new ArrayList<>();
    }

    public Node(int _val) {
        this.val = _val;
        this.children = new ArrayList<>();
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = (_children != null) ? _children : new ArrayList<>();
    }
};
