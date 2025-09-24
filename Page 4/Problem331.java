import java.util.ArrayList;
import java.util.List;

public class Problem331 {
    public static void main(String[] args) {
        // Example usage
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        Solution solution = new Solution();
        System.out.println(solution.isValidSerialization(preorder)); // Output: true
    }
}

class Solution {
    public boolean isValidSerialization(String preorder) {
        List<String> stk = new ArrayList<>();
        for (String s : preorder.split(",")) {
            stk.add(s);
            while (stk.size() >= 3 && stk.get(stk.size() - 1).equals("#")
                    && stk.get(stk.size() - 2).equals("#") && !stk.get(stk.size() - 3).equals("#")) {
                stk.remove(stk.size() - 1);
                stk.remove(stk.size() - 1);
                stk.remove(stk.size() - 1);
                stk.add("#");
            }
        }
        return stk.size() == 1 && stk.get(0).equals("#");
    }
}