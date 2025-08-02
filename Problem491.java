import java.util.List;
import java.util.ArrayList;

public class Problem491 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 4, 6, 7, 7 };
        Solution solution = new Solution();
        List<List<Integer>> result = solution.findSubsequences(nums);
        System.out.println("Subsequences: " + result); // Expected output: [[4, 6], [4, 6, 7], [4, 6, 7, 7], [4, 7], [4,
                                                       // 7, 7], [6, 7], [6, 7, 7], [7, 7]]
    }
}

class Solution {
    private int[] nums;
    private List<List<Integer>> ans;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        ans = new ArrayList<>();
        dfs(0, -1000, new ArrayList<>());
        return ans;
    }

    private void dfs(int u, int last, List<Integer> t) {
        if (u == nums.length) {
            if (t.size() > 1) {
                ans.add(new ArrayList<>(t));
            }
            return;
        }
        if (nums[u] >= last) {
            t.add(nums[u]);
            dfs(u + 1, nums[u], t);
            t.remove(t.size() - 1);
        }
        if (nums[u] != last) {
            dfs(u + 1, last, t);
        }
    }
}