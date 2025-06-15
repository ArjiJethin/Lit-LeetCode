public class Problem243 {
    public static void main(String[] args) {
        // Example usage
        String[] wordsDict = { "practice", "makes", "perfect", "coding", "makes" };
        String word1 = "coding";
        String word2 = "practice";
        Solution sol = new Solution();
        int result = sol.shortestDistance(wordsDict, word1, word2);
        System.out.println(result); // Should print the shortest distance
    }
}

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int ans = 0x3f3f3f3f;
        for (int k = 0, i = -1, j = -1; k < wordsDict.length; ++k) {
            if (wordsDict[k].equals(word1)) {
                i = k;
            }
            if (wordsDict[k].equals(word2)) {
                j = k;
            }
            if (i != -1 && j != -1) {
                ans = Math.min(ans, Math.abs(i - j));
            }
        }
        return ans;
    }
}