1class Solution {
2
3    public long maxTotalValue(int[] nums, int k) {
4        int n = nums.length;
5        int logn = 32 - Integer.numberOfLeadingZeros(n);
6        int[][] stMax = new int[n][logn];
7        int[][] stMin = new int[n][logn];
8        for (int i = 0; i < n; i++) {
9            stMax[i][0] = stMin[i][0] = nums[i];
10        }
11        for (int j = 1; j < logn; j++) {
12            for (int i = 0; i + (1 << j) <= n; i++) {
13                stMax[i][j] = Math.max(
14                    stMax[i][j - 1],
15                    stMax[i + (1 << (j - 1))][j - 1]
16                );
17                stMin[i][j] = Math.min(
18                    stMin[i][j - 1],
19                    stMin[i + (1 << (j - 1))][j - 1]
20                );
21            }
22        }
23        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
24        for (int l = 0; l < n; l++) {
25            int j = 31 - Integer.numberOfLeadingZeros(n - 1 - l + 1);
26            int mx = Math.max(stMax[l][j], stMax[n - 1 - (1 << j) + 1][j]);
27            int mn = Math.min(stMin[l][j], stMin[n - 1 - (1 << j) + 1][j]);
28            pq.offer(new int[] { mx - mn, l, n - 1 });
29        }
30        long ans = 0;
31        while (k-- > 0) {
32            int[] top = pq.poll();
33            ans += top[0];
34            int l = top[1];
35            int r = top[2];
36            if (r > l) {
37                int j = 31 - Integer.numberOfLeadingZeros(r - 1 - l + 1);
38                int mx = Math.max(stMax[l][j], stMax[r - 1 - (1 << j) + 1][j]);
39                int mn = Math.min(stMin[l][j], stMin[r - 1 - (1 << j) + 1][j]);
40                pq.offer(new int[] { mx - mn, l, r - 1 });
41            }
42        }
43        return ans;
44    }
45}