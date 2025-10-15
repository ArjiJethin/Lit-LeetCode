import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem498 {
    public static void main(String[] args) {
        // Example usage
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        Solution solution = new Solution();
        int[] result = solution.findDiagonalOrder(mat);
        System.out.print("Diagonal order: ");
        for (int v : result) {
            System.out.print(v + " "); // Expected output: 1 2 4 7 5 3 6 8 9
        }
    }
}

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int idx = 0;
        List<Integer> t = new ArrayList<>();
        for (int k = 0; k < m + n - 1; ++k) {
            int i = k < n ? 0 : k - n + 1;
            int j = k < n ? k : n - 1;
            while (i < m && j >= 0) {
                t.add(mat[i][j]);
                ++i;
                --j;
            }
            if (k % 2 == 0) {
                Collections.reverse(t);
            }
            for (int v : t) {
                ans[idx++] = v;
            }
            t.clear();
        }
        return ans;
    }
}