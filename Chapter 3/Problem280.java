import java.util.Arrays;

public class Problem280 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 5, 1, 1, 6, 4 };
        Solution solution = new Solution();
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums)); // Expected output: a wiggle sorted array
    }
}

class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                swap(nums, i, i - 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}