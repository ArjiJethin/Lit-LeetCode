1class Solution {
2    public int findMin(int[] nums) {
3        int n = nums.length - 1;
4        int last = nums[n];
5        int left = 0, right = n;
6
7        while (left < n && nums[left] == last)
8            left++;
9
10        while (left < right) {
11            int mid = left + right >> 1;
12
13            if (nums[mid] > last)
14                left = mid + 1;
15            else
16                right = mid;
17        }
18
19        return nums[left];
20    }
21}