import java.util.*;

public class Problem151 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "  hello world!  ";
        String result = solution.reverseWords(s);
        System.out.println(result); // Output: "world! hello"
    }
}

class Solution {
    public String reverseWords(String s) {
        List<String> words = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }
}