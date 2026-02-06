1class Solution {
2    public int minRemoval(int[] nums, int k) {
3        Arrays.sort(nums);
4        int cnt = 0;
5        int n = nums.length;
6        for (int i = 0; i < n; ++i) {
7            int j = n;
8            if (1L * nums[i] * k <= nums[n - 1]) {
9                j = Arrays.binarySearch(nums, nums[i] * k + 1);
10                j = j < 0 ? -j - 1 : j;
11            }
12            cnt = Math.max(cnt, j - i);
13        }
14        return n - cnt;
15    }
16}