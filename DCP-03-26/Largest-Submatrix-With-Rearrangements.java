1class Solution {
2    public int largestSubmatrix(int[][] matrix) {
3        int m = matrix.length;
4        int n = matrix[0].length;
5        int ans = 0;
6        
7        for (int row = 0; row < m; row++) {
8            for (int col = 0; col < n; col++) {
9                if (matrix[row][col] != 0 && row > 0) {
10                    matrix[row][col] += matrix[row - 1][col];
11                }
12            }
13            
14            int[] currRow = matrix[row].clone();
15            Arrays.sort(currRow);
16            for (int i = 0; i < n; i++) {
17                ans = Math.max(ans, currRow[i] * (n - i));
18            }
19        }
20        
21        return ans;
22    }
23}