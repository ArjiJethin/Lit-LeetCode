public class Problem312 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 3, 1, 5, 8 };
        Solution solution = new Solution();
        System.out.println(solution.maxCoins(nums)); // Output: 167
    }
}

class Solution {
    public int maxCoins(int[] nums) {
        int[] vals = new int[nums.length + 2];
        vals[0] = 1;
        vals[vals.length - 1] = 1;
        System.arraycopy(nums, 0, vals, 1, nums.length);
        int n = vals.length;
        int[][] dp = new int[n][n];
        for (int l = 2; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + vals[i] * vals[k] * vals[j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}