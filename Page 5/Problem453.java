import java.util.Arrays;

public class Problem453 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 2, 3 };
        Solution solution = new Solution();
        int result = solution.minMoves(nums);
        System.out.println("Minimum moves to equal array elements: " + result); // Expected output: 3
    }
}

class Solution {
    public int minMoves(int[] nums) {
        return Arrays.stream(nums).sum() - Arrays.stream(nums).min().getAsInt() * nums.length;
    }
}