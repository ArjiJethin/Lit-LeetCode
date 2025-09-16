import java.util.*;

public class Problem159 {
    public static void main(String[] args) {
        String s = "abcabcabc";
        Solution solution = new Solution();
        int result = solution.lengthOfLongestSubstringTwoDistinct(s);
        System.out.println("Length of longest substring with at most two distinct characters: " + result);
    }
}

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        int n = s.length();
        int ans = 0;
        for (int i = 0, j = 0; i < n; ++i) {
            char c = s.charAt(i);
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            while (cnt.size() > 2) {
                char t = s.charAt(j++);
                cnt.put(t, cnt.get(t) - 1);
                if (cnt.get(t) == 0) {
                    cnt.remove(t);
                }
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}