class Solution {
    public int change(int T, int[] A) {
        int N = A.length;
        int[][] dp = new int[N + 1][T + 1];
        for (int i = 0; i <= N; ++i)
            dp[i][0] = 1;
        for (int i = 0; i < N; ++i) {
            for (int t = 1; t <= T; ++t) {
                for (int k = 0; t - k * A[i] >= 0; ++k) {
                    dp[i + 1][t] += dp[i][t - k * A[i]];
                }
            }
        }
        return dp[N][T];
    }
};