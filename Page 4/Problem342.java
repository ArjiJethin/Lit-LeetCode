public class Problem342 {
    public static void main(String[] args) {
        // Example usage
        int n = 16;
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfFour(n)); // Output: true
    }
}

class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}