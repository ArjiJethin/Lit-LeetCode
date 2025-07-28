public class Problem396 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 4, 3, 2, 6 }; // Example input
        int result = solution.maxRotateFunction(nums);
        System.out.println("Maximum rotate function value: " + result);
    }
}

class Solution {
    public int maxRotateFunction(int[] nums) {
        int f = 0;
        int s = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            f += i * nums[i];
            s += nums[i];
        }
        int ans = f;
        for (int i = 1; i < n; ++i) {
            f = f + s - n * nums[n - i];
            ans = Math.max(ans, f);
        }
        return ans;
    }
}