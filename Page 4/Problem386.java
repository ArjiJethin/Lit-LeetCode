import java.util.List;
import java.util.ArrayList;

public class Problem386 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 13; // Example input
        List<Integer> result = solution.lexicalOrder(n);
        System.out.println("Lexicographical order for " + n + ": " + result);
    }
}

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int v = 1;
        for (int i = 0; i < n; ++i) {
            ans.add(v);
            if (v * 10 <= n) {
                v *= 10;
            } else {
                while (v % 10 == 9 || v + 1 > n) {
                    v /= 10;
                }
                ++v;
            }
        }
        return ans;
    }
}