1class Solution {
2    public int countBinarySubstrings(String s) {
3        int[] groups = new int[s.length()];
4        int t = 0;
5        groups[0] = 1;
6        for (int i = 1; i < s.length(); i++) {
7            if (s.charAt(i-1) != s.charAt(i)) {
8                groups[++t] = 1;
9            } else {
10                groups[t]++;
11            }
12        }
13
14        int ans = 0;
15        for (int i = 1; i <= t; i++) {
16            ans += Math.min(groups[i-1], groups[i]);
17        }
18        return ans;
19    }
20}