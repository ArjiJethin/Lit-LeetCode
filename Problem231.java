public class Problem231 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage:
        int n = 16;
        System.out.println(solution.isPowerOfTwo(n)); // Output: true
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}