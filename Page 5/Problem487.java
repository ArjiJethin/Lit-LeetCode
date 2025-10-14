public class Problem487 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 1, 0, 1, 1, 0, 1 };
        Solution solution = new Solution();
        int result = solution.findMaxConsecutiveOnes(nums);
        System.out.println("Maximum consecutive ones with at most one zero flipped: " + result); // Expected output: 5
    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0, r = 0;
        int k = 1;
        while (r < nums.length) {
            if (nums[r++] == 0) {
                --k;
            }
            if (k < 0 && nums[l++] == 0) {
                ++k;
            }
        }
        return r - l;
    }
}