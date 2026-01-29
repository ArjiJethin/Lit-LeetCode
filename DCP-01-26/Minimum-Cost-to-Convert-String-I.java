1class Solution {
2    public long minimumCost(
3        String source, String target, char[] original, char[] changed, int[] cost) {
4        final int inf = 1 << 29;
5        int[][] g = new int[26][26];
6        for (int i = 0; i < 26; ++i) {
7            Arrays.fill(g[i], inf);
8            g[i][i] = 0;
9        }
10        for (int i = 0; i < original.length; ++i) {
11            int x = original[i] - 'a';
12            int y = changed[i] - 'a';
13            int z = cost[i];
14            g[x][y] = Math.min(g[x][y], z);
15        }
16        for (int k = 0; k < 26; ++k) {
17            for (int i = 0; i < 26; ++i) {
18                for (int j = 0; j < 26; ++j) {
19                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
20                }
21            }
22        }
23        long ans = 0;
24        int n = source.length();
25        for (int i = 0; i < n; ++i) {
26            int x = source.charAt(i) - 'a';
27            int y = target.charAt(i) - 'a';
28            if (x != y) {
29                if (g[x][y] >= inf) {
30                    return -1;
31                }
32                ans += g[x][y];
33            }
34        }
35        return ans;
36    }
37}