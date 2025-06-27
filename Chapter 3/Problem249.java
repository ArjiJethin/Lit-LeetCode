import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem249 {
    public static void main(String[] args) {
        // Example usage
        String[] strings = { "abc", "bca", "cab", "xyz", "yzx" };
        Solution solution = new Solution();
        List<List<String>> result = solution.groupStrings(strings);
        for (List<String> group : result) {
            System.out.println(group);
        }
        // Expected output: [["abc", "bca", "cab"], ["xyz", "yzx"]]
    }
}

class Solution {
    @SuppressWarnings("unused")
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> mp = new HashMap<>();
        for (String s : strings) {
            int diff = s.charAt(0) - 'a';
            char[] t = s.toCharArray();
            for (int i = 0; i < t.length; ++i) {
                char d = (char) (t[i] - diff);
                if (d < 'a') {
                    d += 26;
                }
                t[i] = d;
            }
            String key = new String(t);
            mp.computeIfAbsent(key, k -> new ArrayList<String>()).add(s);
        }
        return new ArrayList<>(mp.values());
    }
}