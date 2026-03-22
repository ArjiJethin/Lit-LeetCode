1class Solution {
2
3    public boolean findRotation(int[][] mat, int[][] target) {
4        int n = mat.length;
5        // at most 4 rotations
6        for (int k = 0; k < 4; k++) {
7            // rotation operation
8            for (int i = 0; i < n / 2; i++) {
9                for (int j = 0; j < (n + 1) / 2; j++) {
10                    int temp = mat[i][j];
11                    mat[i][j] = mat[n - 1 - j][i];
12                    mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
13                    mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
14                    mat[j][n - 1 - i] = temp;
15                }
16            }
17
18            if (isEqual(mat, target)) {
19                return true;
20            }
21        }
22        return false;
23    }
24
25    private boolean isEqual(int[][] mat, int[][] target) {
26        int n = mat.length;
27        for (int i = 0; i < n; i++) {
28            for (int j = 0; j < n; j++) {
29                if (mat[i][j] != target[i][j]) {
30                    return false;
31                }
32            }
33        }
34        return true;
35    }
36}