1class Solution {
2
3    private int[] f;
4
5    private void dfs(int[] arr, int id, int d, int n) {
6        if (f[id] != -1) {
7            return;
8        }
9        f[id] = 1;
10        for (int i = id - 1; i >= 0 && id - i <= d && arr[id] > arr[i]; --i) {
11            dfs(arr, i, d, n);
12            f[id] = Math.max(f[id], f[i] + 1);
13        }
14        for (int i = id + 1; i < n && i - id <= d && arr[id] > arr[i]; ++i) {
15            dfs(arr, i, d, n);
16            f[id] = Math.max(f[id], f[i] + 1);
17        }
18    }
19
20    public int maxJumps(int[] arr, int d) {
21        int n = arr.length;
22        f = new int[n];
23        Arrays.fill(f, -1);
24        for (int i = 0; i < n; ++i) {
25            dfs(arr, i, d, n);
26        }
27        int ans = 0;
28        for (int val : f) {
29            ans = Math.max(ans, val);
30        }
31        return ans;
32    }
33}