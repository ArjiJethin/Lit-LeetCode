1class Solution {
2    private List<Integer> nums = new ArrayList<>();
3
4    public TreeNode balanceBST(TreeNode root) {
5        dfs(root);
6        return build(0, nums.size() - 1);
7    }
8
9    private void dfs(TreeNode root) {
10        if (root == null) {
11            return;
12        }
13        dfs(root.left);
14        nums.add(root.val);
15        dfs(root.right);
16    }
17
18    private TreeNode build(int i, int j) {
19        if (i > j) {
20            return null;
21        }
22        int mid = (i + j) >> 1;
23        TreeNode left = build(i, mid - 1);
24        TreeNode right = build(mid + 1, j);
25        return new TreeNode(nums.get(mid), left, right);
26    }
27}