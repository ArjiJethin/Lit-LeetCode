1class Solution {
2
3    public int maxBuilding(int n, int[][] restrictions) {
4        // Convert the constraints to a list for manipulation
5        List<int[]> r = new ArrayList<>();
6        for (int[] res : restrictions) {
7            r.add(new int[] { res[0], res[1] });
8        }
9
10        // Add restriction (1, 0)
11        r.add(new int[] { 1, 0 });
12        // Sort by position
13        r.sort((a, b) -> Integer.compare(a[0], b[0]));
14        // Add restriction (n, n-1)
15        if (r.get(r.size() - 1)[0] != n) {
16            r.add(new int[] { n, n - 1 });
17        }
18
19        int m = r.size();
20
21        // Pass restrictions from left to right
22        for (int i = 1; i < m; ++i) {
23            int dist = r.get(i)[0] - r.get(i - 1)[0];
24            r.get(i)[1] = Math.min(r.get(i)[1], r.get(i - 1)[1] + dist);
25        }
26
27        // Pass restrictions from right to left
28        for (int i = m - 2; i >= 0; --i) {
29            int dist = r.get(i + 1)[0] - r.get(i)[0];
30            r.get(i)[1] = Math.min(r.get(i)[1], r.get(i + 1)[1] + dist);
31        }
32
33        int ans = 0;
34        for (int i = 0; i < m - 1; ++i) {
35            // Calculate the maximum height of the buildings between r[i][0] and r[i][1]
36            int dist = r.get(i + 1)[0] - r.get(i)[0];
37            int best = (dist + r.get(i)[1] + r.get(i + 1)[1]) / 2;
38            ans = Math.max(ans, best);
39        }
40
41        return ans;
42    }
43}