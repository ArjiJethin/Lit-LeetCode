1class Solution {
2    public int concatenatedBinary(int n) {
3        final int mod = (int) 1e9 + 7;
4        long ans = 0;
5        for (int i = 1; i <= n; ++i) {
6            ans = (ans << (32 - Integer.numberOfLeadingZeros(i)) | i) % mod;
7        }
8        return (int) ans;
9    }
10}