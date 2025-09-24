public class Problem326 {
    public static void main(String[] args) {
        // Example usage
        int n = 27;
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree(n)); // Output: true
    }
}

class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}