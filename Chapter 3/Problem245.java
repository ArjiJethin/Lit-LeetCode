public class Problem245 {
    public static void main(String[] args) {
        // Example usage
        String[] wordsDict = { "practice", "makes", "perfect", "coding", "makes" };
        String word1 = "makes";
        String word2 = "coding";
        Solution solution = new Solution();
        int result = solution.shortestWordDistance(wordsDict, word1, word2);
        System.out.println(result); // Expected output: 1
    }
}

class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int ans = wordsDict.length;
        if (word1.equals(word2)) {
            for (int i = 0, j = -1; i < wordsDict.length; ++i) {
                if (wordsDict[i].equals(word1)) {
                    if (j != -1) {
                        ans = Math.min(ans, i - j);
                    }
                    j = i;
                }
            }
        } else {
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
        }
        return ans;
    }
}