public class Problem309 {
    public static void main(String[] args) {
        // Example usage
        int[] prices = { 1, 2, 3, 0, 2 };
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices)); // Output: 3
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int f = 0, f0 = 0, f1 = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            int g0 = Math.max(f0, f1 + prices[i]);
            f1 = Math.max(f1, f - prices[i]);
            f = f0;
            f0 = g0;
        }
        return f0;
    }
}