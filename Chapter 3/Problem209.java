public class Problem209 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage:
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        System.out.println(solution.minSubArrayLen(target, nums)); // Output: 2
    }
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        long s = 0;
        int ans = n + 1;
        for (int i = 0, j = 0; i < n; ++i) {
            s += nums[i];
            while (j < n && s >= target) {
                ans = Math.min(ans, i - j + 1);
                s -= nums[j++];
            }
        }
        return ans <= n ? ans : 0;
    }
}