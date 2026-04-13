1class Solution {
2
3    public int getMinDistance(int[] nums, int target, int start) {
4        int res = nums.length;
5        for (int i = 0; i < nums.length; i++) {
6            if (nums[i] == target) {
7                res = Math.min(res, Math.abs(i - start));
8            }
9        }
10        return res;
11    }
12}