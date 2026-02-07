1class Solution {
2    public int minimumDeletions(String s) {
3        int n = s.length();
4        int[] f = new int[n + 1];
5        int b = 0;
6        for (int i = 1; i <= n; ++i) {
7            if (s.charAt(i - 1) == 'b') {
8                f[i] = f[i - 1];
9                ++b;
10            } else {
11                f[i] = Math.min(f[i - 1] + 1, b);
12            }
13        }
14        return f[n];
15    }
16}