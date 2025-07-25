public class Problem318 {
    public static void main(String[] args) {
        // Example usage
        String[] words = { "abc", "def", "gh" };
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(words)); // Output: 9
    }
}

class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= 1 << (c - 'a');
            }
            for (int j = 0; j < i; ++j) {
                if ((mask[i] & mask[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}