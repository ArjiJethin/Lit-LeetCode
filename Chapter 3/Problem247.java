import java.util.*;

public class Problem247 {
    public static void main(String[] args) {
        // Example usage
        int n = 3;
        Solution solution = new Solution();
        List<String> result = solution.findStrobogrammatic(n);
        System.out.println(result); // Expected output: ["101", "609", "808", "906"]
    }
}

class Solution {
    private static final int[][] PAIRS = { { 1, 1 }, { 8, 8 }, { 6, 9 }, { 9, 6 } };
    private int n;

    public List<String> findStrobogrammatic(int n) {
        this.n = n;
        return dfs(n);
    }

    private List<String> dfs(int u) {
        if (u == 0) {
            return Collections.singletonList("");
        }
        if (u == 1) {
            return Arrays.asList("0", "1", "8");
        }
        List<String> ans = new ArrayList<>();
        for (String v : dfs(u - 2)) {
            for (var p : PAIRS) {
                ans.add(p[0] + v + p[1]);
            }
            if (u != n) {
                ans.add(0 + v + 0);
            }
        }
        return ans;
    }
}