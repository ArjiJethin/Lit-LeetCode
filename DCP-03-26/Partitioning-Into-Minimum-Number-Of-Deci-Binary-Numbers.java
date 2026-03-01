1class Solution {
2    public int minPartitions(String n) {
3        int ans = 0;
4        for (int i = 0; i < n.length(); ++i) {
5            ans = Math.max(ans, n.charAt(i) - '0');
6        }
7        return ans;
8    }
9}