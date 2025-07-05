public class Problem400 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 11; // Example input
        int result = solution.findNthDigit(n);
        System.out.println("The " + n + "th digit in the sequence is: " + result);
    }
}

class Solution {
    public int findNthDigit(int n) {
        int k = 1, cnt = 9;
        while ((long) k * cnt < n) {
            n -= k * cnt;
            ++k;
            cnt *= 10;
        }
        int num = (int) Math.pow(10, k - 1) + (n - 1) / k;
        int idx = (n - 1) % k;
        return String.valueOf(num).charAt(idx) - '0';
    }
}