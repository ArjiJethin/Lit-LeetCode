public class Problem357 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2; // Example input
        int result = solution.countNumbersWithUniqueDigits(n);
        System.out.println("Count of numbers with unique digits for n = " + n + ": " + result);
    }
}

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int ans = 10;
        for (int i = 0, cur = 9; i < n - 1; ++i) {
            cur *= (9 - i);
            ans += cur;
        }
        return ans;
    }
}