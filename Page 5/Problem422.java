import java.util.List;

public class Problem422 {
    public static void main(String[] args) {
        // Example usage
        List<String> words = List.of("abcd", "bnrt", "crmy", "dtye");
        Solution solution = new Solution();
        boolean result = solution.validWordSquare(words);
        System.out.println(result); // Expected output: true
    }
}

class Solution {
    public boolean validWordSquare(List<String> words) {
        int m = words.size();
        for (int i = 0; i < m; ++i) {
            int n = words.get(i).length();
            for (int j = 0; j < n; ++j) {
                if (j >= m || i >= words.get(j).length()) {
                    return false;
                }
                if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}