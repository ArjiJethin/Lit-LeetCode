public class Problem416 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 5, 11, 5 };
        Solution solution = new Solution();
        boolean result = solution.canPartition(nums);
        System.out.println(result); // Expected output: true
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0;
        for (int v : nums) {
            s += v;
        }
        if (s % 2 != 0) {
            return false;
        }
        int n = s >> 1;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int v : nums) {
            for (int j = n; j >= v; --j) {
                dp[j] = dp[j] || dp[j - v];
            }
        }
        return dp[n];
    }
}