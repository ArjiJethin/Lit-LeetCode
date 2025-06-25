public class Problem226 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        @SuppressWarnings("unused")
        TreeNode invertedRoot = solution.invertTree(root);
        // Output the inverted tree structure
    }

    // Helper method to print the tree in pre-order traversal
    static void printTree(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        dfs(root.left);
        dfs(root.right);
    }
}