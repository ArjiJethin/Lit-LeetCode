1public class Solution {
2    // you need treat n as an unsigned value
3    public int reverseBits(int n) {
4        int res = 0;
5        for (int i = 0; i < 32 && n != 0; ++i) {
6            res |= ((n & 1) << (31 - i));
7            n >>>= 1;
8        }
9        return res;
10    }
11}