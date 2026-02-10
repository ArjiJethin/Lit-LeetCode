1class Solution {
2    public int longestBalanced(int[] nums) {
3        int n = nums.length;
4        int ans = 0;
5        for (int i = 0; i < n; ++i) {
6            Set<Integer> vis = new HashSet<>();
7            int[] cnt = new int[2];
8            for (int j = i; j < n; ++j) {
9                if (vis.add(nums[j])) {
10                    ++cnt[nums[j] & 1];
11                }
12                if (cnt[0] == cnt[1]) {
13                    ans = Math.max(ans, j - i + 1);
14                }
15            }
16        }
17        return ans;
18    }
19}