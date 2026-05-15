1class Solution {
2    public int findMin(int[] nums) {
3        int l = 0;
4        int r = nums.length - 1;
5
6        while (l < r) {
7
8            int mid = l + (r - l) / 2;
9
10            if (nums[mid] < nums[r]) {
11                r = mid;
12            }
13            else {
14                l = mid + 1;
15            }
16        }
17
18        return nums[l];
19    }
20}