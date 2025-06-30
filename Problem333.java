public class Problem333 {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(10, new TreeNode(5), new TreeNode(15));
        Solution solution = new Solution();
        System.out.println(solution.largestBSTSubtree(root)); // Output: 3
    }
}

class Solution {
    private int ans;

    public int largestBSTSubtree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if (left[1] < root.val && root.val < right[0]) {
            ans = Math.max(ans, left[2] + right[2] + 1);
            return new int[] {
                    Math.min(root.val, left[0]), Math.max(root.val, right[1]), left[2] + right[2] + 1 };
        }
        return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 0 };
    }
}