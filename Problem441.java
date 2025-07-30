public class Problem441 {
    public static void main(String[] args) {
        // Example usage
        int n = 5;
        Solution solution = new Solution();
        int result = solution.arrangeCoins(n);
        System.out.println("Complete rows of coins: " + result); // Expected output: 2
    }
}

class Solution {
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }
}