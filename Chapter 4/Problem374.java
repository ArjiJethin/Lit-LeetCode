public class Problem374 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10; // Example input
        int result = solution.guessNumber(n);
        System.out.println("The guessed number is: " + result);
    }
}

class Solution {

    // This is a stub for the guess API. Replace its implementation as needed.
    private int guess(int num) {
        // Example stub: always return 0 (correct guess)
        // In LeetCode, this method is provided by the system.
        return 0;
    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (guess(mid) <= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}