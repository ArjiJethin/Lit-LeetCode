1class Solution {
2
3    public int maximumJumps(int[] nums, int target) {
4        int n = nums.length;
5        int[] memo = new int[n];
6        Arrays.fill(memo, Integer.MIN_VALUE);
7
8        int ans = dfs(0, nums, target, memo);
9        return ans < 0 ? -1 : ans;
10    }
11
12    private int dfs(int i, int[] nums, int target, int[] memo) {
13        int n = nums.length;
14        if (i == n - 1) {
15            return 0;
16        }
17        if (memo[i] != Integer.MIN_VALUE) {
18            return memo[i];
19        }
20        int res = Integer.MIN_VALUE;
21        for (int j = i + 1; j < n; j++) {
22            if (Math.abs(nums[i] - nums[j]) <= target) {
23                res = Math.max(res, dfs(j, nums, target, memo) + 1);
24            }
25        }
26        return memo[i] = res;
27    }
28}