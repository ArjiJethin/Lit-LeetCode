public class Problem494 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;
        Solution solution = new Solution();
        int result = solution.findTargetSumWays(nums, target);
        System.out.println("Number of ways to reach target sum " + target + ": " + result); // Expected output: 5
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int v : nums) {
            s += v;
        }
        if (s < target || (s - target) % 2 != 0) {
            return 0;
        }
        int n = (s - target) / 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int v : nums) {
            for (int j = n; j >= v; --j) {
                dp[j] += dp[j - v];
            }
        }
        return dp[n];
    }
}