
public class Problem153 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 3, 4, 5, 1, 2 };
        int result = solution.findMin(nums);
        System.out.println(result); // Output: 1
    }
}

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0] <= nums[n - 1]) {
            return nums[0];
        }
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[0] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}