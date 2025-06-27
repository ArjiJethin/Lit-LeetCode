public class Problem236 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

class Solution {
    public Problem236.TreeNode lowestCommonAncestor(Problem236.TreeNode root, Problem236.TreeNode p,
            Problem236.TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        Problem236.TreeNode left = lowestCommonAncestor(root.left, p, q);
        Problem236.TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }
}