1class Solution {
2
3    public long maximumScore(int[][] grid) {
4        int n = grid[0].length;
5        if (n == 1) {
6            return 0;
7        }
8
9        long[][][] dp = new long[n][n + 1][n + 1];
10        long[][] prevMax = new long[n + 1][n + 1];
11        long[][] prevSuffixMax = new long[n + 1][n + 1];
12        long[][] colSum = new long[n][n + 1];
13
14        for (int c = 0; c < n; c++) {
15            for (int r = 1; r <= n; r++) {
16                colSum[c][r] = colSum[c][r - 1] + grid[r - 1][c];
17            }
18        }
19
20        for (int i = 1; i < n; i++) {
21            for (int currH = 0; currH <= n; currH++) {
22                for (int prevH = 0; prevH <= n; prevH++) {
23                    if (currH <= prevH) {
24                        long extraScore = colSum[i][prevH] - colSum[i][currH];
25                        dp[i][currH][prevH] = Math.max(
26                            dp[i][currH][prevH],
27                            prevSuffixMax[prevH][0] + extraScore
28                        );
29                    } else {
30                        long extraScore =
31                            colSum[i - 1][currH] - colSum[i - 1][prevH];
32                        dp[i][currH][prevH] = Math.max(
33                            dp[i][currH][prevH],
34                            Math.max(
35                                prevSuffixMax[prevH][currH],
36                                prevMax[prevH][currH] + extraScore
37                            )
38                        );
39                    }
40                }
41            }
42
43            for (int currH = 0; currH <= n; currH++) {
44                prevMax[currH][0] = dp[i][currH][0];
45                for (int prevH = 1; prevH <= n; prevH++) {
46                    long penalty = (prevH > currH)
47                        ? (colSum[i][prevH] - colSum[i][currH])
48                        : 0;
49                    prevMax[currH][prevH] = Math.max(
50                        prevMax[currH][prevH - 1],
51                        dp[i][currH][prevH] - penalty
52                    );
53                }
54
55                prevSuffixMax[currH][n] = dp[i][currH][n];
56                for (int prevH = n - 1; prevH >= 0; prevH--) {
57                    prevSuffixMax[currH][prevH] = Math.max(
58                        prevSuffixMax[currH][prevH + 1],
59                        dp[i][currH][prevH]
60                    );
61                }
62            }
63        }
64
65        long ans = 0;
66        for (int k = 0; k <= n; k++) {
67            ans = Math.max(ans, Math.max(dp[n - 1][n][k], dp[n - 1][0][k]));
68        }
69
70        return ans;
71    }
72}