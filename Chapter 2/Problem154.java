
public class Problem154 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 3, 4, 5, 1, 2 };
        int result = solution.findMin(nums);
        System.out.println(result); // Output: 1
    }
}

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                --right;
            }
        }
        return nums[left];
    }
}