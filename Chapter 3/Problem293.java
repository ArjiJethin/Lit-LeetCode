import java.util.List;
import java.util.ArrayList;

public class Problem293 {
    public static void main(String[] args) {
        String currentState = "++++";
        Solution solution = new Solution();
        // Example usage
        List<String> result = solution.generatePossibleNextMoves(currentState);
        System.out.println(result); // Expected output: ["--++", "+--+", "++--"]
    }
}

class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        char[] cs = currentState.toCharArray();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < cs.length - 1; ++i) {
            if (cs[i] == '+' && cs[i + 1] == '+') {
                cs[i] = '-';
                cs[i + 1] = '-';
                ans.add(String.valueOf(cs));
                cs[i] = '+';
                cs[i + 1] = '+';
            }
        }
        return ans;
    }
}