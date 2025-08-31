import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Problem438 {
    public static void main(String[] args) {
        // Example usage
        String s = "cbaebabacd";
        String p = "abc";
        Solution solution = new Solution();
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println("Anagram indices: " + result); // Expected output: [0, 6]
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        List<Integer> ans = new ArrayList<>();
        if (m < n) {
            return ans;
        }
        int[] cnt1 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[p.charAt(i) - 'a'];
        }
        int[] cnt2 = new int[26];
        for (int i = 0; i < n - 1; ++i) {
            ++cnt2[s.charAt(i) - 'a'];
        }
        for (int i = n - 1; i < m; ++i) {
            ++cnt2[s.charAt(i) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                ans.add(i - n + 1);
            }
            --cnt2[s.charAt(i - n + 1) - 'a'];
        }
        return ans;
    }
}