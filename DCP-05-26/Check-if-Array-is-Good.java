1class Solution {
2
3    public boolean isGood(int[] nums) {
4        Arrays.sort(nums);
5        int n = nums.length - 1;
6        for (int i = 0; i < n; i++) {
7            if (nums[i] != i + 1) {
8                return false;
9            }
10        }
11        return nums[n] == n;
12    }
13}