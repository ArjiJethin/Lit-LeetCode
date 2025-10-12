import java.util.*;

public class Problem431 {
    public static void main(String[] args) {
        // Example usage
        Node root = new Node(1, Arrays.asList(new Node(2), new Node(3, Arrays.asList(new Node(4)))));
        Codec codec = new Codec();
        TreeNode serialized = codec.encode(root);
        System.out.println("Serialized TreeNode root value: " + (serialized != null ? serialized.val : "null"));
        Node deserializedRoot = codec.decode(serialized);
        System.out.println("Deserialized root value: " + deserializedRoot.val); // Expected output: 1
    }
}

// Definition for an n-ary tree node.
class Node {
    public int val;
    public List<Node> children;

    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}

// Definition for a binary tree node.
class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        if (root.children == null || root.children.isEmpty()) {
            return node;
        }
        TreeNode left = encode(root.children.get(0));
        node.left = left;
        for (int i = 1; i < root.children.size(); i++) {
            left.right = encode(root.children.get(i));
            left = left.right;
        }
        return node;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode data) {
        if (data == null) {
            return null;
        }
        Node node = new Node(data.val, new ArrayList<>());
        if (data.left == null) {
            return node;
        }
        TreeNode left = data.left;
        while (left != null) {
            node.children.add(decode(left));
            left = left.right;
        }
        return node;
    }
}