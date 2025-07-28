public class Problem376 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 7, 4, 9, 2, 5 }; // Example input
        int result = solution.wiggleMaxLength(nums);
        System.out.println("Maximum length of wiggle subsequence: " + result);
    }
}

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                up = Math.max(up, down + 1);
            } else if (nums[i] < nums[i - 1]) {
                down = Math.max(down, up + 1);
            }
        }
        return Math.max(up, down);
    }
}