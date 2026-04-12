1class Solution {
2
3    private int getDistance(int p, int q) {
4        int x1 = p / 6;
5        int y1 = p % 6;
6        int x2 = q / 6;
7        int y2 = q % 6;
8        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
9    }
10
11    public int minimumDistance(String word) {
12        int n = word.length();
13        int[][][] dp = new int[n][26][26];
14        for (int i = 0; i < n; ++i) {
15            for (int j = 0; j < 26; ++j) {
16                for (int k = 0; k < 26; ++k) {
17                    dp[i][j][k] = Integer.MAX_VALUE / 2;
18                }
19            }
20        }
21
22        for (int i = 0; i < 26; ++i) {
23            dp[0][i][word.charAt(0) - 'A'] = 0;
24            dp[0][word.charAt(0) - 'A'][i] = 0;
25        }
26
27        for (int i = 1; i < n; ++i) {
28            int cur = word.charAt(i) - 'A';
29            int prev = word.charAt(i - 1) - 'A';
30            int d = getDistance(prev, cur);
31
32            for (int j = 0; j < 26; ++j) {
33                dp[i][cur][j] = Math.min(dp[i][cur][j], dp[i - 1][prev][j] + d);
34                dp[i][j][cur] = Math.min(dp[i][j][cur], dp[i - 1][j][prev] + d);
35
36                if (prev == j) {
37                    for (int k = 0; k < 26; ++k) {
38                        int d0 = getDistance(k, cur);
39                        dp[i][cur][j] = Math.min(
40                            dp[i][cur][j],
41                            dp[i - 1][k][j] + d0
42                        );
43                        dp[i][j][cur] = Math.min(
44                            dp[i][j][cur],
45                            dp[i - 1][j][k] + d0
46                        );
47                    }
48                }
49            }
50        }
51
52        int ans = Integer.MAX_VALUE / 2;
53        for (int i = 0; i < 26; ++i) {
54            for (int j = 0; j < 26; ++j) {
55                ans = Math.min(ans, dp[n - 1][i][j]);
56            }
57        }
58        return ans;
59    }
60}