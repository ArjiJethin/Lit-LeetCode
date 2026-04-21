1class Solution {
2
3    private int[] fa;
4    private int[] rank;
5
6    private int find(int x) {
7        if (fa[x] != x) {
8            fa[x] = find(fa[x]);
9        }
10        return fa[x];
11    }
12
13    private void union(int x, int y) {
14        x = find(x);
15        y = find(y);
16        if (x == y) return;
17        if (rank[x] < rank[y]) {
18            int temp = x;
19            x = y;
20            y = temp;
21        }
22        fa[y] = x;
23        if (rank[x] == rank[y]) {
24            rank[x]++;
25        }
26    }
27
28    public int minimumHammingDistance(
29        int[] source,
30        int[] target,
31        int[][] allowedSwaps
32    ) {
33        int n = source.length;
34        fa = new int[n];
35        rank = new int[n];
36        for (int i = 0; i < n; i++) {
37            fa[i] = i;
38        }
39
40        for (int[] pair : allowedSwaps) {
41            union(pair[0], pair[1]);
42        }
43
44        Map<Integer, Map<Integer, Integer>> sets = new HashMap<>();
45        for (int i = 0; i < n; i++) {
46            int f = find(i);
47            sets.putIfAbsent(f, new HashMap<>());
48            Map<Integer, Integer> cnt = sets.get(f);
49            cnt.put(source[i], cnt.getOrDefault(source[i], 0) + 1);
50        }
51
52        int ans = 0;
53        for (int i = 0; i < n; i++) {
54            int f = find(i);
55            Map<Integer, Integer> cnt = sets.get(f);
56            if (cnt.getOrDefault(target[i], 0) > 0) {
57                cnt.put(target[i], cnt.get(target[i]) - 1);
58            } else {
59                ans++;
60            }
61        }
62        return ans;
63    }
64}