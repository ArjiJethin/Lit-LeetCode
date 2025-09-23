import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Problem311 {
    public static void main(String[] args) {
        // Example usage
        int[][] mat1 = {
                { 1, 0, 0 },
                { 0, 0, 2 },
                { 0, 3, 0 }
        };
        int[][] mat2 = {
                { 0, 4 },
                { 5, 6 },
                { 7, 8 }
        };
        Solution solution = new Solution();
        int[][] result = solution.multiply(mat1, mat2);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}

class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length, n = mat2[0].length;
        int[][] ans = new int[m][n];
        var g1 = f(mat1);
        var g2 = f(mat2);
        for (int i = 0; i < m; ++i) {
            for (int[] p : g1[i]) {
                int k = p[0], x = p[1];
                for (int[] q : g2[k]) {
                    int j = q[0], y = q[1];
                    ans[i][j] += x * y;
                }
            }
        }
        return ans;
    }

    private List<int[]>[] f(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        @SuppressWarnings("unchecked")
        List<int[]>[] g = (List<int[]>[]) new ArrayList[m];
        Arrays.setAll(g, _ -> new ArrayList<>());
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] != 0) {
                    g[i].add(new int[] { j, mat[i][j] });
                }
            }
        }
        return g;
    }
}