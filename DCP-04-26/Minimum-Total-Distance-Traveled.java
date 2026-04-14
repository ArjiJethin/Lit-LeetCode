1import java.util.*;
2
3class Solution {
4    long[][] dp;
5
6    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
7        Collections.sort(robot);
8        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
9
10        int n = robot.size();
11        int m = factory.length;
12
13        dp = new long[n][m];
14        for (long[] row : dp) Arrays.fill(row, -1);
15
16        return solve(0, 0, robot, factory);
17    }
18
19    private long solve(int i, int j, List<Integer> robot, int[][] factory) {
20        int n = robot.size();
21        int m = factory.length;
22
23        // all robots assigned
24        if (i == n) return 0;
25
26        // no factory left
27        if (j == m) return (long)1e15;
28
29        if (dp[i][j] != -1) return dp[i][j];
30
31        long res = solve(i, j + 1, robot, factory); // skip factory
32
33        long cost = 0;
34        int pos = factory[j][0];
35        int limit = factory[j][1];
36
37        // assign k robots to this factory
38        for (int k = 0; k < limit && i + k < n; k++) {
39            cost += Math.abs(robot.get(i + k) - pos);
40            res = Math.min(res, cost + solve(i + k + 1, j + 1, robot, factory));
41        }
42
43        return dp[i][j] = res;
44    }
45}