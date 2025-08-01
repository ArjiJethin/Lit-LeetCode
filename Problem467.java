public class Problem467 {
    public static void main(String[] args) {
        // Example usage
        String s1 = "acb";
        int n1 = 4;
        String s2 = "ab";
        int n2 = 2;
        Solution solution = new Solution();
        int result = solution.getMaxRepetitions(s1, n1, s2, n2);
        System.out.println("Maximum repetitions: " + result); // Expected output: 2
    }
}

class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int m = s1.length(), n = s2.length();
        int[][] d = new int[n][0];
        for (int i = 0; i < n; ++i) {
            int j = i;
            int cnt = 0;
            for (int k = 0; k < m; ++k) {
                if (s1.charAt(k) == s2.charAt(j)) {
                    if (++j == n) {
                        j = 0;
                        ++cnt;
                    }
                }
            }
            d[i] = new int[] { cnt, j };
        }
        int ans = 0;
        for (int j = 0; n1 > 0; --n1) {
            ans += d[j][0];
            j = d[j][1];
        }
        return ans / n2;
    }
}