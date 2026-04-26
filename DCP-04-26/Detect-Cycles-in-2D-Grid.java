1class Solution {
2
3    public boolean containsCycle(char[][] grid) {
4        int m = grid.length;
5        int n = grid[0].length;
6        UnionFind uf = new UnionFind(m * n);
7        for (int i = 0; i < m; ++i) {
8            for (int j = 0; j < n; ++j) {
9                if (i > 0 && grid[i][j] == grid[i - 1][j]) {
10                    if (!uf.findAndUnite(i * n + j, (i - 1) * n + j)) {
11                        return true;
12                    }
13                }
14                if (j > 0 && grid[i][j] == grid[i][j - 1]) {
15                    if (!uf.findAndUnite(i * n + j, i * n + j - 1)) {
16                        return true;
17                    }
18                }
19            }
20        }
21        return false;
22    }
23}
24
25class UnionFind {
26
27    int[] parent;
28    int[] size;
29    int n;
30    int setCount;
31
32    public UnionFind(int n) {
33        parent = new int[n];
34        for (int i = 0; i < n; ++i) {
35            parent[i] = i;
36        }
37        size = new int[n];
38        Arrays.fill(size, 1);
39        this.n = n;
40        setCount = n;
41    }
42
43    public int findset(int x) {
44        return parent[x] == x ? x : (parent[x] = findset(parent[x]));
45    }
46
47    public void unite(int x, int y) {
48        if (size[x] < size[y]) {
49            int temp = x;
50            x = y;
51            y = temp;
52        }
53        parent[y] = x;
54        size[x] += size[y];
55        --setCount;
56    }
57
58    public boolean findAndUnite(int x, int y) {
59        int parentX = findset(x);
60        int parentY = findset(y);
61        if (parentX != parentY) {
62            unite(parentX, parentY);
63            return true;
64        }
65        return false;
66    }
67}