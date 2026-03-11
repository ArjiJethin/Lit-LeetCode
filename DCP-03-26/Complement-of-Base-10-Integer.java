1class Solution {
2    public int bitwiseComplement(int n) {
3        if (n == 0) {
4            return 1;
5        }
6        int ans = 0;
7        boolean find = false;
8        for (int i = 30; i >= 0; --i) {
9            int b = n & (1 << i);
10            if (!find && b == 0) {
11                continue;
12            }
13            find = true;
14            if (b == 0) {
15                ans |= (1 << i);
16            }
17        }
18        return ans;
19    }
20}