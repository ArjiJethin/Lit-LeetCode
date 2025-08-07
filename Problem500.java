import java.util.ArrayList;
import java.util.List;

public class Problem500 {
    public static void main(String[] args) {
        // Example usage
        String[] words = { "Hello", "Alaska", "Dad", "Peace" };
        Solution solution = new Solution();
        String[] result = solution.findWords(words);
        System.out.print("Words that can be typed using one row: ");
        for (String word : result) {
            System.out.print(word + " "); // Expected output: "Alaska Dad"
        }
    }
}

class Solution {
    public String[] findWords(String[] words) {
        String s = "12210111011122000010020202";
        List<String> ans = new ArrayList<>();
        for (var w : words) {
            String t = w.toLowerCase();
            char x = s.charAt(t.charAt(0) - 'a');
            boolean ok = true;
            for (char c : t.toCharArray()) {
                if (s.charAt(c - 'a') != x) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans.add(w);
            }
        }
        return ans.toArray(new String[0]);
    }
}