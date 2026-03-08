1class Solution {
2    public String findDifferentBinaryString(String[] nums) {
3        int mask = 0;
4        for (var x : nums) {
5            int cnt = 0;
6            for (int i = 0; i < x.length(); ++i) {
7                if (x.charAt(i) == '1') {
8                    ++cnt;
9                }
10            }
11            mask |= 1 << cnt;
12        }
13        for (int i = 0;; ++i) {
14            if ((mask >> i & 1) == 0) {
15                return "1".repeat(i) + "0".repeat(nums.length - i);
16            }
17        }
18    }
19}