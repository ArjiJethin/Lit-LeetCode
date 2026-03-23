1class Solution {
2
3    public int maxProductPath(int[][] grid) {
4        final int MOD = 1000000000 + 7;
5        int m = grid.length;
6        int n = grid[0].length;
7        long[][] maxgt = new long[m][n];
8        long[][] minlt = new long[m][n];
9
10        maxgt[0][0] = minlt[0][0] = grid[0][0];
11        for (int i = 1; i < n; i++) {
12            maxgt[0][i] = minlt[0][i] = maxgt[0][i - 1] * grid[0][i];
13        }
14        for (int i = 1; i < m; i++) {
15            maxgt[i][0] = minlt[i][0] = maxgt[i - 1][0] * grid[i][0];
16        }
17
18        for (int i = 1; i < m; i++) {
19            for (int j = 1; j < n; j++) {
20                if (grid[i][j] >= 0) {
21                    maxgt[i][j] =
22                        Math.max(maxgt[i][j - 1], maxgt[i - 1][j]) * grid[i][j];
23                    minlt[i][j] =
24                        Math.min(minlt[i][j - 1], minlt[i - 1][j]) * grid[i][j];
25                } else {
26                    maxgt[i][j] =
27                        Math.min(minlt[i][j - 1], minlt[i - 1][j]) * grid[i][j];
28                    minlt[i][j] =
29                        Math.max(maxgt[i][j - 1], maxgt[i - 1][j]) * grid[i][j];
30                }
31            }
32        }
33        if (maxgt[m - 1][n - 1] < 0) {
34            return -1;
35        } else {
36            return (int) (maxgt[m - 1][n - 1] % MOD);
37        }
38    }
39}