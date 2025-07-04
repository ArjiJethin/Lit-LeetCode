public class Problem367 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare(16)); // true
        System.out.println(solution.isPerfectSquare(14)); // false
        System.out.println(solution.isPerfectSquare(25)); // true
        System.out.println(solution.isPerfectSquare(1)); // true
        System.out.println(solution.isPerfectSquare(0)); // true
    }
}

class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;
        while (left < right) {
            long mid = (left + right) >>> 1;
            if (mid * mid >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left * left == num;
    }
}