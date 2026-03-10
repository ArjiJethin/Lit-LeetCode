1class Solution {
2
3    public int numberOfStableArrays(int zero, int one, int limit) {
4        final int MOD = 1000000007;
5        int[][][] dp = new int[zero + 1][one + 1][2];
6        for (int i = 0; i <= zero; i++) {
7            for (int j = 0; j <= one; j++) {
8                for (int lastBit = 0; lastBit <= 1; lastBit++) {
9                    if (i == 0) {
10                        if (lastBit == 0 || j > limit) {
11                            dp[i][j][lastBit] = 0;
12                        } else {
13                            dp[i][j][lastBit] = 1;
14                        }
15                    } else if (j == 0) {
16                        if (lastBit == 1 || i > limit) {
17                            dp[i][j][lastBit] = 0;
18                        } else {
19                            dp[i][j][lastBit] = 1;
20                        }
21                    } else if (lastBit == 0) {
22                        dp[i][j][lastBit] = dp[i - 1][j][0] + dp[i - 1][j][1];
23                        if (i > limit) {
24                            dp[i][j][lastBit] -= dp[i - limit - 1][j][1];
25                        }
26                    } else {
27                        dp[i][j][lastBit] = dp[i][j - 1][0] + dp[i][j - 1][1];
28                        if (j > limit) {
29                            dp[i][j][lastBit] -= dp[i][j - limit - 1][0];
30                        }
31                    }
32                    dp[i][j][lastBit] %= MOD;
33                    if (dp[i][j][lastBit] < 0) {
34                        dp[i][j][lastBit] += MOD;
35                    }
36                }
37            }
38        }
39        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
40    }
41}