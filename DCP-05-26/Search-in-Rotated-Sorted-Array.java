1class Solution {
2    public int search(int[] nums, int target) {
3        int n = nums.length;
4        int left = 0, right = n - 1;
5        while (left < right) {
6            int mid = (left + right) >> 1;
7            if (nums[0] <= nums[mid]) {
8                if (nums[0] <= target && target <= nums[mid]) {
9                    right = mid;
10                } else {
11                    left = mid + 1;
12                }
13            } else {
14                if (nums[mid] < target && target <= nums[n - 1]) {
15                    left = mid + 1;
16                } else {
17                    right = mid;
18                }
19            }
20        }
21        return nums[left] == target ? left : -1;
22    }
23}
24