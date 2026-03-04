1class Solution {
2    public int numSpecial(int[][] mat) {
3        int m = mat.length, n = mat[0].length;
4        int[] r = new int[m];
5        int[] c = new int[n];
6        for (int i = 0; i < m; ++i) {
7            for (int j = 0; j < n; ++j) {
8                r[i] += mat[i][j];
9                c[j] += mat[i][j];
10            }
11        }
12        int ans = 0;
13        for (int i = 0; i < m; ++i) {
14            for (int j = 0; j < n; ++j) {
15                if (mat[i][j] == 1 && r[i] == 1 && c[j] == 1) {
16                    ++ans;
17                }
18            }
19        }
20        return ans;
21    }
22}