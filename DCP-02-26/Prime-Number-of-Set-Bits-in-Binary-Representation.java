1class Solution {
2    public int countPrimeSetBits(int L, int R) {
3        int ans = 0;
4        for (int x = L; x <= R; ++x)
5            if (isSmallPrime(Integer.bitCount(x)))
6                ans++;
7        return ans;
8    }
9    public boolean isSmallPrime(int x) {
10        return (x == 2 || x == 3 || x == 5 || x == 7 ||
11                x == 11 || x == 13 || x == 17 || x == 19);
12    }
13}