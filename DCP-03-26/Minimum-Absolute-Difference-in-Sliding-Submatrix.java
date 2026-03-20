1class Solution {
2
3    public int[][] minAbsDiff(int[][] grid, int k) {
4        int m = grid.length;
5        int n = grid[0].length;
6        int[][] res = new int[m - k + 1][n - k + 1];
7        for (int i = 0; i + k <= m; i++) {
8            for (int j = 0; j + k <= n; j++) {
9                List<Integer> kgrid = new ArrayList<>();
10                for (int x = i; x < i + k; x++) {
11                    for (int y = j; y < j + k; y++) {
12                        kgrid.add(grid[x][y]);
13                    }
14                }
15                int kmin = Integer.MAX_VALUE;
16                Collections.sort(kgrid);
17                for (int t = 1; t < kgrid.size(); t++) {
18                    if (kgrid.get(t).equals(kgrid.get(t - 1))) {
19                        continue;
20                    }
21                    kmin = Math.min(kmin, kgrid.get(t) - kgrid.get(t - 1));
22                }
23                if (kmin != Integer.MAX_VALUE) {
24                    res[i][j] = kmin;
25                }
26            }
27        }
28        return res;
29    }
30}