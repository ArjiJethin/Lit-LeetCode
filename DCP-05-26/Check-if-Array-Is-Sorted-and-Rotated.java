1class Solution {
2
3    public boolean check(int[] nums) {
4        int n = nums.length;
5        if (n <= 1) return true;
6
7        int inversionCount = 0;
8
9        // For every pair, count the number of inversions.
10        for (int i = 1; i < n; ++i) {
11            if (nums[i] < nums[i - 1]) {
12                ++inversionCount;
13                if (inversionCount > 1) return false;
14            }
15        }
16
17        // Also check between the last and the first element due to rotation
18        if (nums[0] < nums[n - 1]) {
19            ++inversionCount;
20        }
21
22        return inversionCount <= 1;
23    }
24}