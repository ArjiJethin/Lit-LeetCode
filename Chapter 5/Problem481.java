import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem481 {
    public static void main(String[] args) {
        // Example usage
        int n = 7;
        Solution solution = new Solution();
        int result = solution.magicalString(n);
        System.out.println("Number of 1's in the magical string: " + result); // Expected output: 4
    }
}

class Solution {
    public int magicalString(int n) {
        List<Integer> s = new ArrayList<>(Arrays.asList(1, 2, 2));
        for (int i = 2; s.size() < n; ++i) {
            int pre = s.get(s.size() - 1);
            int cur = 3 - pre;
            for (int j = 0; j < s.get(i); ++j) {
                s.add(cur);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (s.get(i) == 1) {
                ++ans;
            }
        }
        return ans;
    }
}