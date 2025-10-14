public class Problem486 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 5, 2 };
        Solution solution = new Solution();
        boolean result = solution.PredictTheWinner(nums);
        System.out.println("Can player 1 win? " + result); // Expected output: false
    }
}

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            f[i][i] = nums[i];
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = Math.max(nums[i] - f[i + 1][j], nums[j] - f[i][j - 1]);
            }
        }
        return f[0][n - 1] >= 0;
    }
}