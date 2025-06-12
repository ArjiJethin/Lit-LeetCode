
public class Problem172 {
    public static void main(String[] args) {
        int n = 100;
        Solution solution = new Solution();
        int result = solution.trailingZeroes(n);
        System.out.println("Number of trailing zeroes in " + n + "! is: " + result);
    }
}

class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n > 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}