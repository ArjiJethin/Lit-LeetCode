import java.util.*;

public class Problem216 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 3, n = 7;
        List<List<Integer>> result = solution.combinationSum3(k, n);
        System.out.println(result); // Output: [[1, 2, 4]]
    }
}

class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private int k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        dfs(1, n);
        return ans;
    }

    private void dfs(int i, int s) {
        if (s == 0) {
            if (t.size() == k) {
                ans.add(new ArrayList<>(t));
            }
            return;
        }
        if (i > 9 || i > s || t.size() >= k) {
            return;
        }
        t.add(i);
        dfs(i + 1, s - i);
        t.remove(t.size() - 1);
        dfs(i + 1, s);
    }
}