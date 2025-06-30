public class Problem337 {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(3, new TreeNode(2, new TreeNode(3), new TreeNode(1)),
                new TreeNode(3, null, new TreeNode(1)));
        Solution_singleRecursion solution = new Solution_singleRecursion();
        System.out.println(solution.rob(root)); // Output: 7
    }
}

class Solution_singleRecursion {

    public int rob(TreeNode root) {

        return Math.max(dfs(root, true), dfs(root, false));
    }

    private int dfs(TreeNode root, boolean isCurrentRootRobbed) {

        if (root == null) {
            return 0;
        }

        if (isCurrentRootRobbed) {
            return root.val + dfs(root.left, false) + dfs(root.right, false);
        } else {
            // child can be either rob or no-rob
            return Math.max(dfs(root.left, true), dfs(root.left, false))
                    + Math.max(dfs(root.right, true), dfs(root.right, false));
        }
    }
}

class Solution {
    /*
     * 1. node value can be negative?
     * 
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(target(root), skip(root));
    }

    private int target(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + skip(root.left) + skip(root.right);
    }

    private int skip(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // @note: not target, but rob again => 因为理论上可以连续skip两层
        // return target(root.left) + target(root.right);
        return rob(root.left) + rob(root.right);
    }
}