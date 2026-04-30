1class Solution {
2
3    public int maxPathScore(int[][] grid, int k) {
4        int m = grid.length;
5        int n = grid[0].length;
6
7        int[][][] dp = new int[m][n][k + 1];
8        for (int i = 0; i < m; i++) {
9            for (int j = 0; j < n; j++) {
10                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
11            }
12        }
13
14        dp[0][0][0] = 0;
15
16        for (int i = 0; i < m; i++) {
17            for (int j = 0; j < n; j++) {
18                for (int c = 0; c <= k; c++) {
19                    if (dp[i][j][c] == Integer.MIN_VALUE) continue;
20
21                    if (i + 1 < m) {
22                        int val = grid[i + 1][j];
23                        int cost = (val == 0 ? 0 : 1);
24                        if (c + cost <= k) {
25                            dp[i + 1][j][c + cost] = Math.max(
26                                dp[i + 1][j][c + cost],
27                                dp[i][j][c] + val
28                            );
29                        }
30                    }
31
32                    if (j + 1 < n) {
33                        int val = grid[i][j + 1];
34                        int cost = (val == 0 ? 0 : 1);
35                        if (c + cost <= k) {
36                            dp[i][j + 1][c + cost] = Math.max(
37                                dp[i][j + 1][c + cost],
38                                dp[i][j][c] + val
39                            );
40                        }
41                    }
42                }
43            }
44        }
45
46        int ans = Integer.MIN_VALUE;
47        for (int c = 0; c <= k; c++) {
48            ans = Math.max(ans, dp[m - 1][n - 1][c]);
49        }
50
51        return ans < 0 ? -1 : ans;
52    }
53}