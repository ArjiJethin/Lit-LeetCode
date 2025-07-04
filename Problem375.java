public class Problem375 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10; // Example input
        int result = solution.getMoneyAmount(n);
        System.out.println("Minimum amount of money needed for n = " + n + ": " + result);
    }
}

class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 10][n + 10];
        for (int l = 2; l <= n; ++l) {
            for (int i = 1; i + l - 1 <= n; ++i) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; ++k) {
                    int t = Math.max(dp[i][k - 1], dp[k + 1][j]) + k;
                    dp[i][j] = Math.min(dp[i][j], t);
                }
            }
        }
        return dp[1][n];
    }
}