public class Problem413 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(solution.numberOfArithmeticSlices(nums)); // Output: 3
    }
}

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0, cnt = 0;
        int d = 3000;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i + 1] - nums[i] == d) {
                ++cnt;
            } else {
                d = nums[i + 1] - nums[i];
                cnt = 0;
            }
            ans += cnt;
        }
        return ans;
    }
}