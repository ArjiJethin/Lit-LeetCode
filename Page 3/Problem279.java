import java.util.Arrays;

public class Problem279 {
    public static void main(String[] args) {
        // Example usage
        int n = 12; // Input number
        Solution solution = new Solution();
        int result = solution.numSquares(n);
        System.out.println(result); // Expected output: minimum number of perfect squares that sum to n
    }
}

class Solution {
    public int numSquares(int n) {
        int m = (int) Math.sqrt(n);
        int[] f = new int[n + 1];
        Arrays.fill(f, 1 << 30);
        f[0] = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = i * i; j <= n; ++j) {
                f[j] = Math.min(f[j], f[j - i * i] + 1);
            }
        }
        return f[n];
    }
}