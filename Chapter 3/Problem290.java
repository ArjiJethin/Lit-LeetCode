import java.util.HashMap;
import java.util.Map;

public class Problem290 {
    public static void main(String[] args) {
        // Example usage
        String pattern = "abba";
        String s = "dog cat cat dog";
        Solution solution = new Solution();
        boolean result = solution.wordPattern(pattern, s);
        System.out.println(result); // Expected output: true
    }
}

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] ws = s.split(" ");
        if (pattern.length() != ws.length) {
            return false;
        }
        Map<Character, String> d1 = new HashMap<>();
        Map<String, Character> d2 = new HashMap<>();
        for (int i = 0; i < ws.length; ++i) {
            char a = pattern.charAt(i);
            String b = ws[i];
            if (!d1.getOrDefault(a, b).equals(b) || d2.getOrDefault(b, a) != a) {
                return false;
            }
            d1.put(a, b);
            d2.put(b, a);
        }
        return true;
    }
}