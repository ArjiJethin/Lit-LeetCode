public class Problem477 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 4, 14, 2 };
        Solution solution = new Solution();
        int result = solution.totalHammingDistance(nums);
        System.out.println("Total Hamming distance: " + result); // Expected output: 6
    }
}

class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 31; ++i) {
            int a = 0, b = 0;
            for (int v : nums) {
                int t = (v >> i) & 1;
                a += t;
                b += t ^ 1;
            }
            ans += a * b;
        }
        return ans;
    }
}