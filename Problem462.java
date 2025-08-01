import java.util.Arrays;

public class Problem462 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 2, 3 };
        Solution solution = new Solution();
        int result = solution.minMoves2(nums);
        System.out.println("Minimum moves to equal array elements: " + result); // Expected output: 2
    }
}

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int k = nums[nums.length >> 1];
        int ans = 0;
        for (int v : nums) {
            ans += Math.abs(v - k);
        }
        return ans;
    }
}