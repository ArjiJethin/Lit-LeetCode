public class Problem242 {
    public static void main(String[] args) {
        // Example usage
        String s = "anagram";
        String t = "nagaram";
        Solution sol = new Solution();
        boolean result = sol.isAnagram(s, t);
        System.out.println(result); // Should print true
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
            --cnt[t.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}