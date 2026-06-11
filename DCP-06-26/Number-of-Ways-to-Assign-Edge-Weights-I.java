1class Solution {
2
3    private static final int MOD = 1_000_000_007;
4
5    private int qpow(int x, int y) {
6        long res = 1;
7        long base = x;
8        while (y > 0) {
9            if ((y & 1) == 1) {
10                res = (res * base) % MOD;
11            }
12            base = (base * base) % MOD;
13            y >>= 1;
14        }
15        return (int) res;
16    }
17
18    private int dfs(List<List<Integer>> g, int x, int f) {
19        int maxDep = 0;
20        for (int y : g.get(x)) {
21            if (y == f) continue;
22            maxDep = Math.max(maxDep, dfs(g, y, x) + 1);
23        }
24        return maxDep;
25    }
26
27    public int assignEdgeWeights(int[][] edges) {
28        int n = edges.length + 1;
29        List<List<Integer>> g = new ArrayList<>();
30        for (int i = 0; i <= n; i++) {
31            g.add(new ArrayList<>());
32        }
33        for (int[] e : edges) {
34            int u = e[0];
35            int v = e[1];
36            g.get(u).add(v);
37            g.get(v).add(u);
38        }
39        int maxDep = dfs(g, 1, 0);
40        return qpow(2, maxDep - 1);
41    }
42}