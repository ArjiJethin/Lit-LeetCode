public class Problem283 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 0, 1, 0, 3, 12 };
        Solution solution = new Solution();
        solution.moveZeroes(nums);
        System.out.println(java.util.Arrays.toString(nums)); // Expected output: [1, 3, 12, 0, 0]
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int i = -1, n = nums.length;
        for (int j = 0; j < n; ++j) {
            if (nums[j] != 0) {
                int t = nums[++i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
    }
}