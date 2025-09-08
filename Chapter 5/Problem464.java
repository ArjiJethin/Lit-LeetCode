import java.util.Map;
import java.util.HashMap;

public class Problem464 {
    public static void main(String[] args) {
        // Example usage
        int maxChoosableInteger = 10;
        int desiredTotal = 11;
        Solution solution = new Solution();
        boolean result = solution.canIWin(maxChoosableInteger, desiredTotal);
        System.out.println("Can I win? " + result); // Expected output: false
    }
}

class Solution {
    private Map<Integer, Boolean> memo = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int s = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (s < desiredTotal) {
            return false;
        }
        return dfs(0, 0, maxChoosableInteger, desiredTotal);
    }

    private boolean dfs(int state, int t, int maxChoosableInteger, int desiredTotal) {
        if (memo.containsKey(state)) {
            return memo.get(state);
        }
        boolean res = false;
        for (int i = 1; i <= maxChoosableInteger; ++i) {
            if (((state >> i) & 1) == 0) {
                if (t + i >= desiredTotal
                        || !dfs(state | 1 << i, t + i, maxChoosableInteger, desiredTotal)) {
                    res = true;
                    break;
                }
            }
        }
        memo.put(state, res);
        return res;
    }
}