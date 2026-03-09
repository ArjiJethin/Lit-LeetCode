1class Solution {
2
3    public int numberOfStableArrays(int zero, int one, int limit) {
4        final long MOD = 1000000007;
5        long[][][] dp = new long[zero + 1][one + 1][2];
6        for (int i = 0; i <= Math.min(zero, limit); i++) {
7            dp[i][0][0] = 1;
8        }
9        for (int j = 0; j <= Math.min(one, limit); j++) {
10            dp[0][j][1] = 1;
11        }
12        for (int i = 1; i <= zero; i++) {
13            for (int j = 1; j <= one; j++) {
14                if (i > limit) {
15                    dp[i][j][0] =
16                        dp[i - 1][j][0] +
17                        dp[i - 1][j][1] -
18                        dp[i - limit - 1][j][1];
19                } else {
20                    dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
21                }
22                dp[i][j][0] = ((dp[i][j][0] % MOD) + MOD) % MOD;
23                if (j > limit) {
24                    dp[i][j][1] =
25                        dp[i][j - 1][1] +
26                        dp[i][j - 1][0] -
27                        dp[i][j - limit - 1][0];
28                } else {
29                    dp[i][j][1] = dp[i][j - 1][1] + dp[i][j - 1][0];
30                }
31                dp[i][j][1] = ((dp[i][j][1] % MOD) + MOD) % MOD;
32            }
33        }
34        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
35    }
36}