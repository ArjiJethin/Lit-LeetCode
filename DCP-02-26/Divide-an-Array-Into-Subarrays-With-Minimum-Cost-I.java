1class Solution {
2    public int minimumCost(int[] nums) {
3        int head2 = Integer.MAX_VALUE;
4        int head3 = Integer.MAX_VALUE;
5
6        for (int i = 1; i < nums.length; i++) {
7            if (nums[i] < head2) {
8                head3 = head2;
9                head2 = nums[i];
10            } else if (nums[i] < head3) {
11                head3 = nums[i];
12            }
13        }
14
15        return nums[0] + head2 + head3;
16    }
17}
18