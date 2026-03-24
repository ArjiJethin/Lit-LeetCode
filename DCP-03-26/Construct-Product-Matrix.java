1class Solution {
2
3    public int[][] constructProductMatrix(int[][] grid) {
4        final int MOD = 12345;
5        int n = grid.length;
6        int m = grid[0].length;
7        int[][] p = new int[n][m];
8
9        long suffix = 1;
10        for (int i = n - 1; i >= 0; i--) {
11            for (int j = m - 1; j >= 0; j--) {
12                p[i][j] = (int) suffix;
13                suffix = (suffix * grid[i][j]) % MOD;
14            }
15        }
16
17        long prefix = 1;
18        for (int i = 0; i < n; i++) {
19            for (int j = 0; j < m; j++) {
20                p[i][j] = (int) (((long) p[i][j] * prefix) % MOD);
21                prefix = (prefix * grid[i][j]) % MOD;
22            }
23        }
24
25        return p;
26    }
27}