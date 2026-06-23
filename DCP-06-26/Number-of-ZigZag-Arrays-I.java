1public class Solution {
2
3    private static final int MOD = 1_000_000_007;
4
5    public int zigZagArrays(int n, int l, int r) {
6        int[] dp0 = new int[r + 1];
7        int[] dp1 = new int[r + 1];
8        int[] sum0 = new int[r + 2];
9        int[] sum1 = new int[r + 2];
10
11        for (int i = l; i <= r; i++) {
12            dp0[i] = 1;
13            dp1[i] = 1;
14            sum0[i] = i - l + 1;
15            sum1[i] = i - l + 1;
16        }
17
18        for (int i = 1; i < n; i++) {
19            for (int j = l; j <= r; j++) {
20                dp0[j] = (sum1[r] - sum1[j] + MOD) % MOD;
21                dp1[j] = sum0[j - 1];
22            }
23
24            sum0[l] = dp0[l];
25            sum1[l] = dp1[l];
26            for (int j = l + 1; j <= r; j++) {
27                sum0[j] = (sum0[j - 1] + dp0[j]) % MOD;
28                sum1[j] = (sum1[j - 1] + dp1[j]) % MOD;
29            }
30        }
31
32        return (sum0[r] + sum1[r]) % MOD;
33    }
34}