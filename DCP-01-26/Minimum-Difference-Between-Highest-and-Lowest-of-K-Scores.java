1class Solution {
2    public int minimumDifference(int[] nums, int k) {
3        int minDifference = Integer.MAX_VALUE;
4        Arrays.sort(nums);
5        int length = nums.length;
6        for (int i = k - 1; i < length; i++) {
7            int difference = nums[i] - nums[i - k + 1];
8            minDifference = Math.min(minDifference, difference);
9        }
10        return minDifference;
11    }
12}