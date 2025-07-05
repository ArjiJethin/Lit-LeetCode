public class Problem392 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abc";
        String t = "ahbgdc"; // Example input
        boolean result = solution.isSubsequence(s, t);
        System.out.println("Is '" + s + "' a subsequence of '" + t + "': " + result);
    }
}

class Solution {

    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                ++i;
            }
            ++j;
        }
        return i == m;
    }
}