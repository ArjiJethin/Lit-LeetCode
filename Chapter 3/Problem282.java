import java.util.List;
import java.util.ArrayList;

public class Problem282 {
    public static void main(String[] args) {
        // Example usage
        String num = "123";
        int target = 6;
        Solution solution = new Solution();
        List<String> result = solution.addOperators(num, target);
        System.out.println(result); // Expected output: ["1+2+3", "1*2*3"]
    }
}

class Solution {
    private List<String> ans;
    private String num;
    private int target;

    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        this.num = num;
        this.target = target;
        dfs(0, 0, 0, "");
        return ans;
    }

    private void dfs(int u, long prev, long curr, String path) {
        if (u == num.length()) {
            if (curr == target)
                ans.add(path);
            return;
        }
        for (int i = u; i < num.length(); i++) {
            if (i != u && num.charAt(u) == '0') {
                break;
            }
            long next = Long.parseLong(num.substring(u, i + 1));
            if (u == 0) {
                dfs(i + 1, next, next, path + next);
            } else {
                dfs(i + 1, next, curr + next, path + "+" + next);
                dfs(i + 1, -next, curr - next, path + "-" + next);
                dfs(i + 1, prev * next, curr - prev + prev * next, path + "*" + next);
            }
        }
    }
}