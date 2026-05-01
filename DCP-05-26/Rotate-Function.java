1class Solution {
2
3    public int maxRotateFunction(int[] nums) {
4        int f = 0;
5        int n = nums.length;
6        int numSum = Arrays.stream(nums).sum();
7        for (int i = 0; i < n; i++) {
8            f += i * nums[i];
9        }
10        int res = f;
11        for (int i = n - 1; i > 0; i--) {
12            f += numSum - n * nums[i];
13            res = Math.max(res, f);
14        }
15        return res;
16    }
17}