1class Solution {
2    public void rotate(int[][] mat) {
3        int n = mat.length, k = n - 1;
4        for (int i = 0; i < n >> 1; i++)
5            for (int j = i; j < k - i; j++) {
6                int t = mat[i][j];
7                mat[i][j] = mat[k - j][i];
8                mat[k - j][i] = mat[k - i][k - j];
9                mat[k - i][k - j] = mat[j][k - i];
10                mat[j][k - i] = t;
11            }
12    }
13}