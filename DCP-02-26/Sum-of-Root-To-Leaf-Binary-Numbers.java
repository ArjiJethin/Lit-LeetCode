1class Solution {
2    public int sumRootToLeaf(TreeNode root) {
3        return dfs(root, 0);
4    }
5
6    private int dfs(TreeNode root, int t) {
7        if (root == null) {
8            return 0;
9        }
10        t = (t << 1) | root.val;
11        if (root.left == null && root.right == null) {
12            return t;
13        }
14        return dfs(root.left, t) + dfs(root.right, t);
15    }
16}