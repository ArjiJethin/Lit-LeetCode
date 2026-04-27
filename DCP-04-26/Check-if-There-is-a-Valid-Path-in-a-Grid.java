1class Solution {
2
3    class DisjointSet {
4
5        int[] f;
6
7        public DisjointSet(int m, int n) {
8            f = new int[m * n];
9            for (int i = 0; i < m * n; ++i) {
10                f[i] = i;
11            }
12        }
13
14        public int find(int x) {
15            return x == f[x] ? x : (f[x] = find(f[x]));
16        }
17
18        public void merge(int x, int y) {
19            f[find(x)] = find(y);
20        }
21    }
22
23    int[][] grid;
24    int m;
25    int n;
26    DisjointSet ds;
27
28    public boolean hasValidPath(int[][] grid) {
29        this.grid = grid;
30        m = grid.length;
31        n = grid[0].length;
32        ds = new DisjointSet(m, n);
33        for (int i = 0; i < m; ++i) {
34            for (int j = 0; j < n; ++j) {
35                handler(i, j);
36            }
37        }
38        return ds.find(getId(0, 0)) == ds.find(getId(m - 1, n - 1));
39    }
40
41    public int getId(int x, int y) {
42        return x * n + y;
43    }
44
45    public void detectL(int x, int y) {
46        if (
47            y - 1 >= 0 &&
48            (grid[x][y - 1] == 4 || grid[x][y - 1] == 6 || grid[x][y - 1] == 1)
49        ) {
50            ds.merge(getId(x, y), getId(x, y - 1));
51        }
52    }
53
54    public void detectR(int x, int y) {
55        if (
56            y + 1 < n &&
57            (grid[x][y + 1] == 3 || grid[x][y + 1] == 5 || grid[x][y + 1] == 1)
58        ) {
59            ds.merge(getId(x, y), getId(x, y + 1));
60        }
61    }
62
63    public void detectU(int x, int y) {
64        if (
65            x - 1 >= 0 &&
66            (grid[x - 1][y] == 3 || grid[x - 1][y] == 4 || grid[x - 1][y] == 2)
67        ) {
68            ds.merge(getId(x, y), getId(x - 1, y));
69        }
70    }
71
72    public void detectD(int x, int y) {
73        if (
74            x + 1 < m &&
75            (grid[x + 1][y] == 5 || grid[x + 1][y] == 6 || grid[x + 1][y] == 2)
76        ) {
77            ds.merge(getId(x, y), getId(x + 1, y));
78        }
79    }
80
81    public void handler(int x, int y) {
82        switch (grid[x][y]) {
83            case 1:
84                detectL(x, y);
85                detectR(x, y);
86                break;
87            case 2:
88                detectU(x, y);
89                detectD(x, y);
90                break;
91            case 3:
92                detectL(x, y);
93                detectD(x, y);
94                break;
95            case 4:
96                detectR(x, y);
97                detectD(x, y);
98                break;
99            case 5:
100                detectL(x, y);
101                detectU(x, y);
102                break;
103            case 6:
104                detectR(x, y);
105                detectU(x, y);
106        }
107    }
108}