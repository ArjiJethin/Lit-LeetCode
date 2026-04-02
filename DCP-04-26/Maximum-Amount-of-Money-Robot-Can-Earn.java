1class Solution {
2
3    public int maximumAmount(int[][] coins) {
4        int m = coins.length;
5        int n = coins[0].length;
6        int[][][] memo = new int[m][n][3];
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                Arrays.fill(memo[i][j], Integer.MIN_VALUE);
10            }
11        }
12
13        return dfs(coins, memo, 0, 0, 2);
14    }
15
16    private int dfs(int[][] coins, int[][][] memo, int i, int j, int k) {
17        int m = coins.length;
18        int n = coins[0].length;
19        if (i >= m || j >= n) {
20            return Integer.MIN_VALUE;
21        }
22
23        int x = coins[i][j];
24        // arrive at the destination
25        if (i == m - 1 && j == n - 1) {
26            return k > 0 ? Math.max(0, x) : x;
27        }
28
29        if (memo[i][j][k] != Integer.MIN_VALUE) {
30            return memo[i][j][k];
31        }
32
33        // not neutralize
34        int res =
35            Math.max(
36                dfs(coins, memo, i + 1, j, k),
37                dfs(coins, memo, i, j + 1, k)
38            ) +
39            x;
40
41        if (k > 0 && x < 0) {
42            // neutralize
43            res = Math.max(
44                res,
45                Math.max(
46                    dfs(coins, memo, i + 1, j, k - 1),
47                    dfs(coins, memo, i, j + 1, k - 1)
48                )
49            );
50        }
51
52        memo[i][j][k] = res;
53        return res;
54    }
55}