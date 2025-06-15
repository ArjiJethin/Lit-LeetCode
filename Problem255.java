import java.util.Deque;
import java.util.ArrayDeque;

public class Problem255 {
    public static void main(String[] args) {
        // Example usage
        int[] preorder = { 5, 2, 1, 3, 6 };
        Solution sol = new Solution();
        boolean result = sol.verifyPreorder(preorder);
        System.out.println(result); // Should print true
    }
}

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stk = new ArrayDeque<>();
        int last = Integer.MIN_VALUE;
        for (int x : preorder) {
            if (x < last) {
                return false;
            }
            while (!stk.isEmpty() && stk.peek() < x) {
                last = stk.poll();
            }
            stk.push(x);
        }
        return true;
    }
}