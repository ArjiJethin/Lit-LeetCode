public class Problem258 {
    public static void main(String[] args) {
        // Example usage
        int num = 38;
        Solution sol = new Solution();
        int result = sol.addDigits(num);
        System.out.println(result); // Should print 2
    }
}

class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}