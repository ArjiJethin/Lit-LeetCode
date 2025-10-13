public class Problem459 {
    public static void main(String[] args) {
        // Example usage
        String s = "abab";
        Solution solution = new Solution();
        boolean result = solution.repeatedSubstringPattern(s);
        System.out.println("Does the string have a repeated substring pattern? " + result); // Expected output: true
    }
}

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}