public class Problem338 {
    public static void main(String[] args) {
        // Example usage
        int n = 5;
        Solution solution = new Solution();
        int[] result = solution.countBits(n);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }
}