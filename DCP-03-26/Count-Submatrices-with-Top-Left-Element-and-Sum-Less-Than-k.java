1class Solution {
2
3    public int countSubmatrices(int[][] grid, int k) {
4        int n = grid.length;
5        int m = grid[0].length;
6        int[] cols = new int[m];
7        int res = 0;
8
9        for (int i = 0; i < n; i++) {
10            int rows = 0;
11            for (int j = 0; j < m; j++) {
12                cols[j] += grid[i][j];
13                rows += cols[j];
14                if (rows <= k) {
15                    res++;
16                }
17            }
18        }
19
20        return res;
21    }
22}