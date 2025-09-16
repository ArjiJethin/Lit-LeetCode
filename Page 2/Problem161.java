
public class Problem161 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ab";
        Solution solution = new Solution();
        boolean result = solution.isOneEditDistance(s, t);
        System.out.println("Is one edit distance: " + result);
    }
}

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return isOneEditDistance(t, s);
        }
        if (m - n > 1) {
            return false;
        }
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                if (m == n) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                return s.substring(i + 1).equals(t.substring(i));
            }
        }
        return m == n + 1;
    }
}