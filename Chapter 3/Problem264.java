public class Problem264 {
    public static void main(String[] args) {
        // Example usage
        int n = 10; // Find the 10th ugly number
        Solution solution = new Solution();
        int result = solution.nthUglyNumber(n);
        System.out.println(result); // Expected output: 12
    }
}

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; ++i) {
            int next2 = dp[p2] * 2, next3 = dp[p3] * 3, next5 = dp[p5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2)
                ++p2;
            if (dp[i] == next3)
                ++p3;
            if (dp[i] == next5)
                ++p5;
        }
        return dp[n - 1];
    }
}