1class DSU {
2
3    int[] parent;
4
5    DSU(int[] parent) {
6        this.parent = parent.clone();
7    }
8
9    int find(int x) {
10        if (parent[x] != x) {
11            parent[x] = find(parent[x]);
12        }
13        return parent[x];
14    }
15
16    void join(int x, int y) {
17        int px = find(x);
18        int py = find(y);
19        parent[px] = py;
20    }
21}
22
23public class Solution {
24
25    private static final int MAX_STABILITY = 200000;
26
27    public int maxStability(int n, int[][] edges, int k) {
28        int ans = -1;
29        if (edges.length < n - 1) {
30            return -1;
31        }
32        List<int[]> mustEdges = new ArrayList<>();
33        List<int[]> optionalEdges = new ArrayList<>();
34
35        for (int[] edge : edges) {
36            if (edge[3] == 1) {
37                mustEdges.add(edge);
38            } else {
39                optionalEdges.add(edge);
40            }
41        }
42
43        if (mustEdges.size() > n - 1) {
44            return -1;
45        }
46
47        optionalEdges.sort((a, b) -> b[2] - a[2]);
48        int selectedInit = 0;
49        int mustMinStability = MAX_STABILITY;
50
51        int[] initParent = new int[n];
52        for (int i = 0; i < n; i++) {
53            initParent[i] = i;
54        }
55        DSU dsuInit = new DSU(initParent);
56
57        for (int[] e : mustEdges) {
58            int u = e[0];
59            int v = e[1];
60            int s = e[2];
61            if (dsuInit.find(u) == dsuInit.find(v) || selectedInit == n - 1) {
62                return -1;
63            }
64            dsuInit.join(u, v);
65            selectedInit++;
66            mustMinStability = Math.min(mustMinStability, s);
67        }
68
69        int l = 0;
70        int r = mustMinStability;
71        while (l < r) {
72            int mid = l + (r - l + 1) / 2;
73
74            DSU dsu = new DSU(dsuInit.parent);
75            int selected = selectedInit;
76            int doubledCount = 0;
77
78            for (int[] e : optionalEdges) {
79                int u = e[0];
80                int v = e[1];
81                int s = e[2];
82                if (dsu.find(u) == dsu.find(v)) {
83                    continue;
84                }
85                if (s >= mid) {
86                    dsu.join(u, v);
87                    selected++;
88                } else if (doubledCount < k && s * 2 >= mid) {
89                    doubledCount++;
90                    dsu.join(u, v);
91                    selected++;
92                } else {
93                    break;
94                }
95                if (selected == n - 1) {
96                    break;
97                }
98            }
99
100            if (selected != n - 1) {
101                r = mid - 1;
102            } else {
103                ans = l = mid;
104            }
105        }
106
107        return ans;
108    }
109}