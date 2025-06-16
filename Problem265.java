import java.util.Arrays;

public class Problem265 {
    public static void main(String[] args) {
        // Example usage
        int[][] costs = {
                { 1, 5, 3 },
                { 2, 9, 4 },
                { 3, 6, 2 }
        };
        Solution solution = new Solution();
        int result = solution.minCostII(costs);
        System.out.println(result); // Expected output: 5
    }
}

class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length, k = costs[0].length;
        int[] f = costs[0].clone();
        for (int i = 1; i < n; ++i) {
            int[] g = costs[i].clone();
            for (int j = 0; j < k; ++j) {
                int t = Integer.MAX_VALUE;
                for (int h = 0; h < k; ++h) {
                    if (h != j) {
                        t = Math.min(t, f[h]);
                    }
                }
                g[j] += t;
            }
            f = g;
        }
        return Arrays.stream(f).min().getAsInt();
    }
}