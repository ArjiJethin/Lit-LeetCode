1class Solution {
2
3    public int minimumDistance(int[] nums) {
4        int n = nums.length;
5        int ans = n + 1;
6
7        for (int i = 0; i < n - 2; i++) {
8            for (int j = i + 1; j < n - 1; j++) {
9                if (nums[i] != nums[j]) {
10                    continue;
11                }
12                for (int k = j + 1; k < n; k++) {
13                    if (nums[j] == nums[k]) {
14                        ans = Math.min(ans, k - i);
15                        break;
16                    }
17                }
18            }
19        }
20
21        return ans == n + 1 ? -1 : ans * 2;
22    }
23}