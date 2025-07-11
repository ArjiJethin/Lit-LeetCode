import java.util.TreeSet;

public class Problem363 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                { 1, 0, 1 },
                { 0, -2, 3 }
        };
        int k = 2;
        int result = solution.maxSumSubmatrix(matrix, k);
        System.out.println("Maximum sum of submatrix no larger than " + k + ": " + result);
    }
}

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        final int inf = 1 << 30;
        int ans = -inf;
        for (int i = 0; i < m; ++i) {
            int[] nums = new int[n];
            for (int j = i; j < m; ++j) {
                for (int h = 0; h < n; ++h) {
                    nums[h] += matrix[j][h];
                }
                int s = 0;
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                for (int x : nums) {
                    s += x;
                    Integer y = ts.ceiling(s - k);
                    if (y != null) {
                        ans = Math.max(ans, s - y);
                    }
                    ts.add(s);
                }
            }
        }
        return ans;
    }
}