
public class Problem162 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        Solution solution = new Solution();
        int result = solution.findPeakElement(nums);
        System.out.println("Index of a peak element: " + result);
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}