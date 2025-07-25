public class Problem344 {
    public static void main(String[] args) {
        // Example usage
        char[] s = { 'h', 'e', 'l', 'l', 'o' };
        Solution solution = new Solution();
        solution.reverseString(s);
        System.out.println(s); // Output: "olleh"
    }
}

class Solution {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; ++i, --j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}