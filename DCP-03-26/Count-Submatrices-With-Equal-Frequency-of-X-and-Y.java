1class Solution {
2
3    public int numberOfSubmatrices(char[][] grid) {
4        int n = grid.length;
5        int m = grid[0].length;
6        int ans = 0;
7        int[][][] sum = new int[n + 1][m + 1][2];
8        for (int i = 0; i < n; i++) {
9            for (int j = 0; j < m; j++) {
10                if (grid[i][j] == 'X') {
11                    sum[i + 1][j + 1][0] =
12                        sum[i + 1][j][0] + sum[i][j + 1][0] - sum[i][j][0] + 1;
13                    sum[i + 1][j + 1][1] = 1;
14                } else if (grid[i][j] == 'Y') {
15                    sum[i + 1][j + 1][0] =
16                        sum[i + 1][j][0] + sum[i][j + 1][0] - sum[i][j][0] - 1;
17                    sum[i + 1][j + 1][1] = sum[i + 1][j][1] | sum[i][j + 1][1];
18                } else {
19                    sum[i + 1][j + 1][0] =
20                        sum[i + 1][j][0] + sum[i][j + 1][0] - sum[i][j][0];
21                    sum[i + 1][j + 1][1] = sum[i + 1][j][1] | sum[i][j + 1][1];
22                }
23                ans += (sum[i + 1][j + 1][0] == 0 && sum[i + 1][j + 1][1] == 1)
24                    ? 1
25                    : 0;
26            }
27        }
28        return ans;
29    }
30}