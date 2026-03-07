1class Solution {
2    public int minFlips(String s) {
3        int n = s.length();
4        String target = "01";
5        int cnt = 0;
6        for (int i = 0; i < n; ++i) {
7            cnt += (s.charAt(i) == target.charAt(i & 1) ? 0 : 1);
8        }
9        int res = Math.min(cnt, n - cnt);
10        for (int i = 0; i < n; ++i) {
11            cnt -= (s.charAt(i) == target.charAt(i & 1) ? 0 : 1);
12            cnt += (s.charAt(i) == target.charAt((i + n) & 1) ? 0 : 1);
13            res = Math.min(res, Math.min(cnt, n - cnt));
14        }
15        return res;
16    }
17}