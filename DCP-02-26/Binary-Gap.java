1class Solution {
2    public int binaryGap(int n) {
3        int ans = 0;
4        for (int i = 0, j = -1; n != 0; ++i, n >>= 1) {
5            if ((n & 1) == 1) {
6                if (j != -1) {
7                    ans = Math.max(ans, i - j);
8                }
9                j = i;
10            }
11        }
12        return ans;
13    }
14}