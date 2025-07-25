public class Problem334 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 2, 3, 4, 5 };
        Solution solution = new Solution();
        System.out.println(solution.increasingTriplet(nums)); // Output: true
    }
}

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > mid) {
                return true;
            }
            if (num <= min) {
                min = num;
            } else {
                mid = num;
            }
        }
        return false;
    }
}