public class Problem268 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 3, 0, 1 };
        Solution sol = new Solution();
        int result = sol.missingNumber(nums);
        System.out.println(result); // Should print 2
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = n;
        for (int i = 0; i < n; ++i) {
            ans ^= (i ^ nums[i]);
        }
        return ans;
    }
}