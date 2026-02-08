1class Solution {
2    public boolean isBalanced(TreeNode root) {
3        return height(root) >= 0;
4    }
5
6    private int height(TreeNode root) {
7        if (root == null) {
8            return 0;
9        }
10        int l = height(root.left);
11        int r = height(root.right);
12        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
13            return -1;
14        }
15        return 1 + Math.max(l, r);
16    }
17}