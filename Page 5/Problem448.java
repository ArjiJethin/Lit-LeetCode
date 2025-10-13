import java.util.List;
import java.util.ArrayList;

public class Problem448 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        Solution solution = new Solution();
        List<Integer> result = solution.findDisappearedNumbers(nums);
        System.out.println("Disappeared numbers: " + result); // Expected output: [5, 6]
    }
}

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int x : nums) {
            int i = Math.abs(x) - 1;
            if (nums[i] > 0) {
                nums[i] *= -1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}