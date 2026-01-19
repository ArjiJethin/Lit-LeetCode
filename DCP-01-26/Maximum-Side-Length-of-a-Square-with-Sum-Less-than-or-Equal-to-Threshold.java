1class Solution {
2    private int m;
3    private int n;
4    private int threshold;
5    private int[][] s;
6
7    public int maxSideLength(int[][] mat, int threshold) {
8        m = mat.length;
9        n = mat[0].length;
10        this.threshold = threshold;
11        s = new int[m + 1][n + 1];
12        for (int i = 1; i <= m; ++i) {
13            for (int j = 1; j <= n; ++j) {
14                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + mat[i - 1][j - 1];
15            }
16        }
17        int l = 0, r = Math.min(m, n);
18        while (l < r) {
19            int mid = (l + r + 1) >> 1;
20            if (check(mid)) {
21                l = mid;
22            } else {
23                r = mid - 1;
24            }
25        }
26        return l;
27    }
28
29    private boolean check(int k) {
30        for (int i = 0; i < m - k + 1; ++i) {
31            for (int j = 0; j < n - k + 1; ++j) {
32                if (s[i + k][j + k] - s[i][j + k] - s[i + k][j] + s[i][j] <= threshold) {
33                    return true;
34                }
35            }
36        }
37        return false;
38    }
39}