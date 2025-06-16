public class Problem266 {
    public static void main(String[] args) {
        // Example usage
        String s = "carerac";
        Solution sol = new Solution();
        boolean result = sol.canPermutePalindrome(s);
        System.out.println(result); // Should print true
    }
}

class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        int odd = 0;
        for (int x : cnt) {
            odd += x & 1;
        }
        return odd < 2;
    }
}