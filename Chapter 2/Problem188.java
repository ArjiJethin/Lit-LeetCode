
public class Problem188 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = { 2, 4, 1, 7, 3, 5 };
        int k = 2;
        int result = solution.maxProfit(k, prices);
        System.out.println(result); // Output: 6
    }
}

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] f = new int[k + 1][2];
        for (int j = 1; j <= k; ++j) {
            f[j][1] = -prices[0];
        }
        for (int i = 1; i < n; ++i) {
            for (int j = k; j > 0; --j) {
                f[j][0] = Math.max(f[j][1] + prices[i], f[j][0]);
                f[j][1] = Math.max(f[j - 1][0] - prices[i], f[j][1]);
            }
        }
        return f[k][0];
    }
}