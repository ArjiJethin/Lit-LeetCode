public class Problem389 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcd";
        String t = "abcde"; // Example input
        char result = solution.findTheDifference(s, t);
        System.out.println("The added character is: " + result);
    }
}

class Solution {
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        for (int i = 0;; ++i) {
            if (--cnt[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
    }
}