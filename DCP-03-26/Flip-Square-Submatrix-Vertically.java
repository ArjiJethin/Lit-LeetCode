1class Solution {
2
3    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
4        for (int i0 = x, i1 = x + k - 1; i0 < i1; i0++, i1--) {
5            for (int j = y; j < y + k; j++) {
6                int temp = grid[i0][j];
7                grid[i0][j] = grid[i1][j];
8                grid[i1][j] = temp;
9            }
10        }
11        return grid;
12    }
13}