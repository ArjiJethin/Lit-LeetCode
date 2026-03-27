1class Solution {
2
3    public boolean areSimilar(int[][] mat, int k) {
4        int m = mat.length;
5        int n = mat[0].length;
6        k %= n;
7
8        for (int i = 0; i < m; i++) {
9            for (int j = 0; j < n; j++) {
10                if (mat[i][j] != mat[i][(j + k) % n]) {
11                    return false;
12                }
13            }
14        }
15        return true;
16    }
17}