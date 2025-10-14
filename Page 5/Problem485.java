public class Problem485 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        Solution solution = new Solution();
        int result = solution.findMaxConsecutiveOnes(nums);
        System.out.println("Maximum consecutive ones: " + result); // Expected output: 3
    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0, ans = 0;
        for (int v : nums) {
            if (v == 1) {
                ++cnt;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 0;
            }
        }
        return Math.max(cnt, ans);
    }
}