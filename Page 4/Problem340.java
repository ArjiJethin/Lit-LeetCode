import java.util.HashMap;
import java.util.Map;

public class Problem340 {
    public static void main(String[] args) {
        // Example usage
        String s = "eceba";
        int k = 2;
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstringKDistinct(s, k)); // Output: 3
    }
}

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> cnt = new HashMap<>();
        int n = s.length();
        int ans = 0, j = 0;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            while (cnt.size() > k) {
                char t = s.charAt(j);
                cnt.put(t, cnt.getOrDefault(t, 0) - 1);
                if (cnt.get(t) == 0) {
                    cnt.remove(t);
                }
                ++j;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}