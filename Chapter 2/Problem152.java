
public class Problem152 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 3, -2, 4 };
        int result = solution.maxProduct(nums);
        System.out.println(result); // Output: 6
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int f = nums[0], g = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int ff = f, gg = g;
            f = Math.max(nums[i], Math.max(ff * nums[i], gg * nums[i]));
            g = Math.min(nums[i], Math.min(ff * nums[i], gg * nums[i]));
            ans = Math.max(ans, f);
        }
        return ans;
    }
}