1class Solution {
2
3    public boolean canPartitionGrid(int[][] grid) {
4        long total = 0;
5        int m = grid.length;
6        int n = grid[0].length;
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                total += grid[i][j];
10            }
11        }
12        for (int k = 0; k < 4; k++) {
13            Set<Long> exist = new HashSet<>();
14            exist.add(0L);
15            long sum = 0;
16            m = grid.length;
17            n = grid[0].length;
18            if (m < 2) {
19                grid = rotation(grid);
20                continue;
21            }
22            if (n == 1) {
23                for (int i = 0; i < m - 1; i++) {
24                    sum += grid[i][0];
25                    long tag = sum * 2 - total;
26                    if (tag == 0 || tag == grid[0][0] || tag == grid[i][0]) {
27                        return true;
28                    }
29                }
30                grid = rotation(grid);
31                continue;
32            }
33            for (int i = 0; i < m - 1; i++) {
34                for (int j = 0; j < n; j++) {
35                    exist.add((long) grid[i][j]);
36                    sum += grid[i][j];
37                }
38                long tag = sum * 2 - total;
39                if (i == 0) {
40                    if (
41                        tag == 0 || tag == grid[0][0] || tag == grid[0][n - 1]
42                    ) {
43                        return true;
44                    }
45                    continue;
46                }
47                if (exist.contains(tag)) {
48                    return true;
49                }
50            }
51            grid = rotation(grid);
52        }
53        return false;
54    }
55
56    public int[][] rotation(int[][] grid) {
57        int m = grid.length;
58        int n = grid[0].length;
59        int[][] tmp = new int[n][m];
60        for (int i = 0; i < m; i++) {
61            for (int j = 0; j < n; j++) {
62                tmp[j][m - 1 - i] = grid[i][j];
63            }
64        }
65        return tmp;
66    }
67}