import java.util.List;
import java.util.ArrayList;

public class Problem412 {
    public static void main(String[] args) {
        // Example usage
        int n = 15;
        Solution solution = new Solution();
        List<String> result = solution.fizzBuzz(n);
        for (String s : result) {
            System.out.println(s);
        }
    }
}

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            String s = "";
            if (i % 3 == 0) {
                s += "Fizz";
            }
            if (i % 5 == 0) {
                s += "Buzz";
            }
            if (s.length() == 0) {
                s += i;
            }
            ans.add(s);
        }
        return ans;
    }
}