1class Solution {
2    public int rotatedDigits(int n) {
3        int[] dp = new int[n + 1];
4        int count = 0;
5
6        for (int i = 0; i <= n; i++) {
7            if (i < 10) {
8                if (i == 0 || i == 1 || i == 8) {
9                    dp[i] = 1;
10                } else if (i == 2 || i == 5 || i == 6 || i == 9) {
11                    dp[i] = 2;
12                    count++;
13                } else {
14                    dp[i] = 0;
15                }
16            } else {
17                int a = dp[i / 10];
18                int b = dp[i % 10];
19
20                if (a == 1 && b == 1) {
21                    dp[i] = 1;
22                } else if (a >= 1 && b >= 1) {
23                    dp[i] = 2;
24                    count++;
25                } else {
26                    dp[i] = 0;
27                }
28            }
29        }
30
31        return count;
32    }
33}