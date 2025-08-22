public class Problem404 {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Solution solution = new Solution();
        int result = solution.sumOfLeftLeaves(root);
        System.out.println(result); // Expected output: 24
    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        res += sumOfLeftLeaves(root.left);
        res += sumOfLeftLeaves(root.right);
        return res;
    }
}