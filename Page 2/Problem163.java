import java.util.*;

public class Problem163 {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 3, 50, 75 };
        int lower = 0;
        int upper = 99;
        Solution solution = new Solution();
        List<List<Integer>> result = solution.findMissingRanges(nums, lower, upper);
        System.out.println("Missing ranges: " + result);
    }
}

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        if (n == 0) {
            return List.of(List.of(lower, upper));
        }
        List<List<Integer>> ans = new ArrayList<>();
        if (nums[0] > lower) {
            ans.add(List.of(lower, nums[0] - 1));
        }
        for (int i = 1; i < n; ++i) {
            if (nums[i] - nums[i - 1] > 1) {
                ans.add(List.of(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (nums[n - 1] < upper) {
            ans.add(List.of(nums[n - 1] + 1, upper));
        }
        return ans;
    }
}