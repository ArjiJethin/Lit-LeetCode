public class Problem222 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(solution.countNodes(root)); // Output: 6
    }
}

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == right) {
            return (1 << left) + countNodes(root.right);
        }
        return (1 << right) + countNodes(root.left);
    }

    private int depth(TreeNode root) {
        int d = 0;
        for (; root != null; root = root.left) {
            ++d;
        }
        return d;
    }
}