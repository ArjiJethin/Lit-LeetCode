public class Problem285 {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left; // Node with value 3
        Solution solution = new Solution();
        TreeNode successor = solution.inorderSuccessor(root, p);

        if (successor != null) {
            System.out.println("Inorder Successor of " + p.val + " is: " + successor.val);
        } else {
            System.out.println("Inorder Successor not found.");
        }
    }
}

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        while (root != null) {
            if (root.val > p.val) {
                ans = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans;
    }
}