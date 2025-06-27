import java.util.List;
import java.util.ArrayList;

public class Problem254 {
    public static void main(String[] args) {
        // Example usage
        int n = 12;
        Solution solution = new Solution();
        List<List<Integer>> result = solution.getFactors(n);
        System.out.println(result); // Expected output: [[2, 6], [3, 4], [2, 2, 3]]
    }
}

class Solution {
    private List<Integer> t = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> getFactors(int n) {
        dfs(n, 2);
        return ans;
    }

    private void dfs(int n, int i) {
        if (!t.isEmpty()) {
            List<Integer> cp = new ArrayList<>(t);
            cp.add(n);
            ans.add(cp);
        }
        for (int j = i; j <= n / j; ++j) {
            if (n % j == 0) {
                t.add(j);
                dfs(n / j, j);
                t.remove(t.size() - 1);
            }
        }
    }
}