public class Problem461 {
    public static void main(String[] args) {
        // Example usage
        int x = 1;
        int y = 4;
        Solution solution = new Solution();
        int result = solution.hammingDistance(x, y);
        System.out.println("Hamming distance: " + result); // Expected output: 2
    }
}

class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}