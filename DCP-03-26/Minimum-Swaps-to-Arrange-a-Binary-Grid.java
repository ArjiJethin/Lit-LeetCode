1class Solution {
2    public int minSwaps(int[][] grid) {
3        int n = grid.length;
4        int[] pos = new int[n];
5        Arrays.fill(pos, -1);
6        for (int i = 0; i < n; ++i) {
7            for (int j = n - 1; j >= 0; --j) {
8                if (grid[i][j] == 1) {
9                    pos[i] = j;
10                    break;
11                }
12            }
13        }
14        int ans = 0;
15        for (int i = 0; i < n; ++i) {
16            int k = -1;
17            for (int j = i; j < n; ++j) {
18                if (pos[j] <= i) {
19                    ans += j - i;
20                    k = j;
21                    break;
22                }
23            }
24            if (k == -1) {
25                return -1;
26            }
27            for (; k > i; --k) {
28                int t = pos[k];
29                pos[k] = pos[k - 1];
30                pos[k - 1] = t;
31            }
32        }
33        return ans;
34    }
35}