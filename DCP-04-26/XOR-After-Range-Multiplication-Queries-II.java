1class Solution {
2
3    private static final int MOD = 1_000_000_007;
4
5    private int pow(long x, long y) {
6        long res = 1;
7        while (y > 0) {
8            if ((y & 1) == 1) {
9                res = (res * x) % MOD;
10            }
11            x = (x * x) % MOD;
12            y >>= 1;
13        }
14        return (int) res;
15    }
16
17    public int xorAfterQueries(int[] nums, int[][] queries) {
18        int n = nums.length;
19        int T = (int) Math.sqrt(n);
20        List<List<int[]>> groups = new ArrayList<>(T);
21        for (int i = 0; i < T; i++) {
22            groups.add(new ArrayList<>());
23        }
24
25        for (int[] q : queries) {
26            int l = q[0];
27            int r = q[1];
28            int k = q[2];
29            int v = q[3];
30            if (k < T) {
31                groups.get(k).add(new int[] { l, r, v });
32            } else {
33                for (int i = l; i <= r; i += k) {
34                    nums[i] = (int) (((long) nums[i] * v) % MOD);
35                }
36            }
37        }
38
39        long[] dif = new long[n + T];
40        for (int k = 1; k < T; k++) {
41            if (groups.get(k).isEmpty()) {
42                continue;
43            }
44            Arrays.fill(dif, 1);
45            for (int[] q : groups.get(k)) {
46                int l = q[0];
47                int r = q[1];
48                int v = q[2];
49                dif[l] = (dif[l] * v) % MOD;
50                int R = ((r - l) / k + 1) * k + l;
51                dif[R] = (dif[R] * pow(v, MOD - 2)) % MOD;
52            }
53
54            for (int i = k; i < n; i++) {
55                dif[i] = (dif[i] * dif[i - k]) % MOD;
56            }
57            for (int i = 0; i < n; i++) {
58                nums[i] = (int) (((long) nums[i] * dif[i]) % MOD);
59            }
60        }
61
62        int res = 0;
63        for (int x : nums) {
64            res ^= x;
65        }
66        return res;
67    }
68}