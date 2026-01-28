1class Solution {
2    public int minCost(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5        if (k > 0 && grid[0][0] >= grid[m - 1][n - 1]) {
6            return 0;
7        }
8
9        int mx = 0;
10        for (int[] row : grid) {
11            for (int x : row) {
12                mx = Math.max(mx, x);
13            }
14        }
15
16        int[] sufMinF = new int[mx + 2];
17        Arrays.fill(sufMinF, Integer.MAX_VALUE);
18        int[] minF = new int[mx + 1];
19        int[] f = new int[n + 1];
20
21        for (int t = 0; t <= k; t++) {
22            Arrays.fill(minF, Integer.MAX_VALUE);
23            Arrays.fill(f, Integer.MAX_VALUE / 2);
24            f[1] = -grid[0][0];
25            for (int[] row : grid) {
26                for (int j = 0; j < n; j++) {
27                    int x = row[j];
28                    f[j + 1] = Math.min(Math.min(f[j], f[j + 1]) + x, sufMinF[x]);
29                    minF[x] = Math.min(minF[x], f[j + 1]);
30                }
31            }
32            boolean done = true;
33            for (int i = mx; i >= 0; i--) {
34                int mn = Math.min(sufMinF[i + 1], minF[i]);
35                if (mn < sufMinF[i]) {
36                    sufMinF[i] = mn;
37                    done = false;
38                }
39            }
40            if (done) {
41                break;
42            }
43        }
44
45        return f[n];
46    }
47}