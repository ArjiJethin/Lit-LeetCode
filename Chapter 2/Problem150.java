import java.util.*;

public class Problem150 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println(solution.evalRPN(tokens)); // Output: 9
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stk = new ArrayDeque<>();
        for (String t : tokens) {
            if (t.length() > 1 || Character.isDigit(t.charAt(0))) {
                stk.push(Integer.parseInt(t));
            } else {
                int y = stk.pop();
                int x = stk.pop();
                switch (t) {
                    case "+":
                        stk.push(x + y);
                        break;
                    case "-":
                        stk.push(x - y);
                        break;
                    case "*":
                        stk.push(x * y);
                        break;
                    default:
                        stk.push(x / y);
                        break;
                }
            }
        }
        return stk.pop();
    }
}