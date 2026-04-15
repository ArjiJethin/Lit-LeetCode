1class Solution {
2
3    public int closestTarget(String[] words, String target, int startIndex) {
4        int ans = words.length;
5        int n = words.length;
6
7        for (int i = 0; i < n; ++i) {
8            if (words[i].equals(target)) {
9                int dist = Math.abs(i - startIndex);
10                ans = Math.min(ans, Math.min(dist, n - dist));
11            }
12        }
13
14        return ans < n ? ans : -1;
15    }
16}