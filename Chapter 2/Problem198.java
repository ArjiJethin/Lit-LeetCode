
public class Problem198 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(solution.rob(nums)); // Output: 12
    }
}

class Solution {
    public int rob(int[] nums) {
        int a = 0, b = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int c = Math.max(nums[i] + a, b);
            a = b;
            b = c;
        }
        return b;
    }
}