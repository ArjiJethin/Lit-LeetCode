1class Solution {
2
3    public int[][] rotateGrid(int[][] grid, int k) {
4        int m = grid.length;
5        int n = grid[0].length;
6        int nlayer = Math.min(m / 2, n / 2); // level count
7        // enumerate each layer counterclockwise starting from the top-left corner
8        for (int layer = 0; layer < nlayer; ++layer) {
9            List<Integer> r = new ArrayList<>();
10            List<Integer> c = new ArrayList<>();
11            List<Integer> val = new ArrayList<>(); // each element's row index, column index, and value
12            for (int i = layer; i < m - layer - 1; ++i) { // left
13                r.add(i);
14                c.add(layer);
15                val.add(grid[i][layer]);
16            }
17            for (int j = layer; j < n - layer - 1; ++j) { // down
18                r.add(m - layer - 1);
19                c.add(j);
20                val.add(grid[m - layer - 1][j]);
21            }
22            for (int i = m - layer - 1; i > layer; --i) { // right
23                r.add(i);
24                c.add(n - layer - 1);
25                val.add(grid[i][n - layer - 1]);
26            }
27            for (int j = n - layer - 1; j > layer; --j) { // up
28                r.add(layer);
29                c.add(j);
30                val.add(grid[layer][j]);
31            }
32            int total = val.size(); // total number of elements in each layer
33            int kk = k % total; // equivalent number of rotations
34            // find the value at each index after rotation
35            for (int i = 0; i < total; ++i) {
36                int idx = (i + total - kk) % total; // the index corresponding to the value after rotation
37                grid[r.get(i)][c.get(i)] = val.get(idx);
38            }
39        }
40        return grid;
41    }
42}