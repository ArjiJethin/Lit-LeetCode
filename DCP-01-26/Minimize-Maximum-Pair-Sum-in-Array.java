1class Solution {
2    public int minPairSum(int[] nums) {
3        Arrays.sort(nums);
4        int res = 0, n = nums.length;
5        for (int i = 0; i < (n >> 1); ++i) {
6            res = Math.max(res, nums[i] + nums[n - i - 1]);
7        }
8        return res;
9    }
10}