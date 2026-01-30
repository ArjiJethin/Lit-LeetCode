1class Node {
2    Node[] children = new Node[26];
3    int v = -1;
4}
5
6class Solution {
7    private final long inf = 1L << 60;
8    private Node root = new Node();
9    private int idx;
10
11    private long[][] g;
12    private char[] s;
13    private char[] t;
14    private Long[] f;
15
16    public long minimumCost(
17        String source, String target, String[] original, String[] changed, int[] cost) {
18        int m = cost.length;
19        g = new long[m << 1][m << 1];
20        s = source.toCharArray();
21        t = target.toCharArray();
22        for (int i = 0; i < g.length; ++i) {
23            Arrays.fill(g[i], inf);
24            g[i][i] = 0;
25        }
26        for (int i = 0; i < m; ++i) {
27            int x = insert(original[i]);
28            int y = insert(changed[i]);
29            g[x][y] = Math.min(g[x][y], cost[i]);
30        }
31        for (int k = 0; k < idx; ++k) {
32            for (int i = 0; i < idx; ++i) {
33                if (g[i][k] >= inf) {
34                    continue;
35                }
36                for (int j = 0; j < idx; ++j) {
37                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
38                }
39            }
40        }
41        f = new Long[s.length];
42        long ans = dfs(0);
43        return ans >= inf ? -1 : ans;
44    }
45
46    private int insert(String w) {
47        Node node = root;
48        for (char c : w.toCharArray()) {
49            int i = c - 'a';
50            if (node.children[i] == null) {
51                node.children[i] = new Node();
52            }
53            node = node.children[i];
54        }
55        if (node.v < 0) {
56            node.v = idx++;
57        }
58        return node.v;
59    }
60
61    private long dfs(int i) {
62        if (i >= s.length) {
63            return 0;
64        }
65        if (f[i] != null) {
66            return f[i];
67        }
68        long res = s[i] == t[i] ? dfs(i + 1) : inf;
69        Node p = root, q = root;
70        for (int j = i; j < s.length; ++j) {
71            p = p.children[s[j] - 'a'];
72            q = q.children[t[j] - 'a'];
73            if (p == null || q == null) {
74                break;
75            }
76            if (p.v < 0 || q.v < 0) {
77                continue;
78            }
79            long t = g[p.v][q.v];
80            if (t < inf) {
81                res = Math.min(res, t + dfs(j + 1));
82            }
83        }
84        return f[i] = res;
85    }
86}