import java.util.List;
import java.util.ArrayList;

public class Problem228 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 0, 1, 2, 4, 5, 7 };
        System.out.println(solution.summaryRanges(nums)); // Output: ["0->2", "4->5", "7"]
    }
}

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for (int i = 0, j, n = nums.length; i < n; i = j + 1) {
            j = i;
            while (j + 1 < n && nums[j + 1] == nums[j] + 1) {
                ++j;
            }
            ans.add(f(nums, i, j));
        }
        return ans;
    }

    private String f(int[] nums, int i, int j) {
        return i == j ? nums[i] + "" : String.format("%d->%d", nums[i], nums[j]);
    }
}