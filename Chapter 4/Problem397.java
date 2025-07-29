public class Problem397 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 8; // Example input
        int result = solution.integerReplacement(n);
        System.out.println("Minimum number of replacements for " + n + ": " + result);

        n = 7; // Another example input
        result = solution.integerReplacement(n);
        System.out.println("Minimum number of replacements for " + n + ": " + result);
    }
}

class Solution {
    public int integerReplacement(int n) {
        int ans = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n != 3 && (n & 3) == 3) {
                ++n;
            } else {
                --n;
            }
            ++ans;
        }
        return ans;
    }
}