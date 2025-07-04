public class Problem371 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = 1, b = 2; // Example input
        int result = solution.getSum(a, b);
        System.out.println("Sum of " + a + " and " + b + " is: " + result);
    }
}

class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}