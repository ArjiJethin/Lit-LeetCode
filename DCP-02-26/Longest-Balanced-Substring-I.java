1class Solution {
2
3    public int longestBalanced(String s) {
4        int n = s.length();
5        int res = 0;
6        int[] cnt = new int[26];
7
8        for (int i = 0; i < n; i++) {
9            Arrays.fill(cnt, 0);
10            for (int j = i; j < n; j++) {
11                boolean flag = true;
12                int c = s.charAt(j) - 'a';
13                cnt[c]++;
14
15                for (int x : cnt) {
16                    if (x > 0 && x != cnt[c]) {
17                        flag = false;
18                        break;
19                    }
20                }
21
22                if (flag) {
23                    res = Math.max(res, j - i + 1);
24                }
25            }
26        }
27        return res;
28    }
29}