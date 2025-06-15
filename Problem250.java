
public class Problem250 {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        Solution solution = new Solution();
        int result = solution.countUnivalSubtrees(root);
        System.out.println(result); // Expected output: 4
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private int ans;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean l = dfs(root.left);
        boolean r = dfs(root.right);
        if (!l || !r) {
            return false;
        }
        int a = root.left == null ? root.val : root.left.val;
        int b = root.right == null ? root.val : root.right.val;
        if (a == b && b == root.val) {
            ++ans;
            return true;
        }
        return false;
    }
}