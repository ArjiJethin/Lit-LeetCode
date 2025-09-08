import java.util.Arrays;

public class Problem455 {
    public static void main(String[] args) {
        // Example usage
        int[] g = { 1, 2, 3 };
        int[] s = { 1, 1 };
        Solution solution = new Solution();
        int result = solution.findContentChildren(g, s);
        System.out.println("Number of content children: " + result); // Expected output: 1
    }
}

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length;
        int n = s.length;
        for (int i = 0, j = 0; i < m; ++i) {
            while (j < n && s[j] < g[i]) {
                ++j;
            }
            if (j++ >= n) {
                return i;
            }
        }
        return m;
    }
}