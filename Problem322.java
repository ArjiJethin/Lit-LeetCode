import java.util.Arrays;

public class Problem322 {
    public static void main(String[] args) {
        // Example usage
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        Solution solution = new Solution();
        System.out.println(solution.coinChange(coins, amount)); // Output: 3
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        final int inf = 1 << 30;
        int n = amount;
        int[] f = new int[n + 1];
        Arrays.fill(f, inf);
        f[0] = 0;
        for (int x : coins) {
            for (int j = x; j <= n; ++j) {
                f[j] = Math.min(f[j], f[j - x] + 1);
            }
        }
        return f[n] >= inf ? -1 : f[n];
    }
}