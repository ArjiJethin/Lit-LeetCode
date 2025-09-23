public class Problem292 {
    public static void main(String[] args) {
        // Example usage
        int n = 4; // Number of stones
        Solution solution = new Solution();
        boolean result = solution.canWinNim(n);
        System.out.println(result); // Expected output: false
    }
}

class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}