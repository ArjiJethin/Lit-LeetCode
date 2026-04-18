1class Solution {
2
3    public int reverse(int n) {
4        int res = 0;
5        while (n > 0) {
6            res = res * 10 + (n % 10);
7            n /= 10;
8        }
9        return res;
10    }
11
12    public int mirrorDistance(int n) {
13        return Math.abs(n - reverse(n));
14    }
15}