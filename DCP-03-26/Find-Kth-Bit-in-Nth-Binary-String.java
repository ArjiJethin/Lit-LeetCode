1class Solution {
2    public char findKthBit(int n, int k) {
3        return (char) ('0' + dfs(n, k));
4    }
5
6    private int dfs(int n, int k) {
7        if (k == 1) {
8            return 0;
9        }
10        if ((k & (k - 1)) == 0) {
11            return 1;
12        }
13        int m = 1 << n;
14        if (k * 2 < m - 1) {
15            return dfs(n - 1, k);
16        }
17        return dfs(n - 1, m - k) ^ 1;
18    }
19}