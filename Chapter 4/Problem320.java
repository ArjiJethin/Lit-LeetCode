import java.util.List;
import java.util.ArrayList;

public class Problem320 {
    public static void main(String[] args) {
        // Example usage
        String word = "word";
        Solution solution = new Solution();
        List<String> abbreviations = solution.generateAbbreviations(word);
        System.out.println(abbreviations); // Output: [word, 1ord, w1rd, wo1d, wor1, 2rd, w2d, 3d, 4]
    }
}

class Solution {
    public List<String> generateAbbreviations(String word) {
        int n = word.length();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i) {
            StringBuilder s = new StringBuilder();
            int cnt = 0;
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 1) {
                    ++cnt;
                } else {
                    if (cnt > 0) {
                        s.append(cnt);
                        cnt = 0;
                    }
                    s.append(word.charAt(j));
                }
            }
            if (cnt > 0) {
                s.append(cnt);
            }
            ans.add(s.toString());
        }
        return ans;
    }
}