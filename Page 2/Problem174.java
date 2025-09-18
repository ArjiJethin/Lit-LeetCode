import java.util.*;

public class Problem174 {
    public static void main(String[] args) {
        int[][] dungeon = {
                { -2, -3, 3 },
                { -5, -10, 1 },
                { 10, 30, -5 }
        };
        Solution solution = new Solution();
        int result = solution.calculateMinimumHP(dungeon);
        System.out.println("Minimum HP required: " + result);
    }
}

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (var e : dp) {
            Arrays.fill(e, 1 << 30);
        }
        dp[m][n - 1] = dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}