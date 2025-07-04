public class Problem377 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 2, 3 }; // Example input
        int target = 4; // Example target
        int result = solution.combinationSum4(nums, target);
        System.out.println("Number of combinations for target " + target + ": " + result);
    }
}

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; ++i) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}