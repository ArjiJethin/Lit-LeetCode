public class Problem235 {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        Solution solution = new Solution();
        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.right; // Node with value 8
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.val); // Should print 6
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val < Math.min(p.val, q.val)) {
                root = root.right;
            } else if (root.val > Math.max(p.val, q.val)) {
                root = root.left;
            } else {
                return root;
            }
        }
    }
}