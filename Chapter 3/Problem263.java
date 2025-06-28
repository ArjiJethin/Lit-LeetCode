public class Problem263 {
    public static void main(String[] args) {
        // Example usage
        int n = 6;
        Solution solution = new Solution();
        boolean result = solution.isUgly(n);
        System.out.println(result); // Expected output: true
    }
}

class Solution {
    public boolean isUgly(int n) {
        if (n < 1)
            return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
}