1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        long total = 0;
5        
6        for (int[] row : grid)
7            for (int x : row)
8                total += x;
9        
10        if ((total & 1) == 1) return false;
11        
12        long target = total / 2, sum = 0;
13        
14        for (int i = 0; i < m - 1; i++) {
15            for (int j = 0; j < n; j++)
16                sum += grid[i][j];
17            if (sum == target) return true;
18        }
19        
20        sum = 0;
21        
22        for (int j = 0; j < n - 1; j++) {
23            for (int i = 0; i < m; i++)
24                sum += grid[i][j];
25            if (sum == target) return true;
26        }
27        
28        return false;
29    }
30}