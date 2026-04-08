1class Solution {
2
3    private static final int MOD = 1_000_000_007;
4
5    public int xorAfterQueries(int[] nums, int[][] queries) {
6        int n = nums.length;
7        for (int[] q : queries) {
8            int l = q[0];
9            int r = q[1];
10            int k = q[2];
11            int v = q[3];
12            for (int i = l; i <= r; i += k) {
13                nums[i] = (int) (((long) nums[i] * v) % MOD);
14            }
15        }
16        int res = 0;
17        for (int x : nums) {
18            res ^= x;
19        }
20        return res;
21    }
22}