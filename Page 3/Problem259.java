import java.util.Arrays;

public class Problem259 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { -2, 0, 1, 3 };
        int target = 2;
        Solution sol = new Solution();
        int result = sol.threeSumSmaller(nums, target);
        System.out.println(result); // Should print 2
    }
}

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0, n = nums.length; i < n; ++i) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if (s >= target) {
                    --k;
                } else {
                    ans += k - j;
                    ++j;
                }
            }
        }
        return ans;
    }
}