public class Problem330 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 2, 2 };
        int n = 5;
        Solution solution = new Solution();
        System.out.println(solution.minPatches(nums, n)); // Output: 0
    }
}

class Solution {
    public int minPatches(int[] nums, int n) {
        long x = 1;
        int ans = 0;
        for (int i = 0; x <= n;) {
            if (i < nums.length && nums[i] <= x) {
                x += nums[i++];
            } else {
                ++ans;
                x <<= 1;
            }
        }
        return ans;
    }
}