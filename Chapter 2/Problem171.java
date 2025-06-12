
public class Problem171 {
    public static void main(String[] args) {
        String columnTitle = "ZY";
        Solution solution = new Solution();
        int result = solution.titleToNumber(columnTitle);
        System.out.println("Column number: " + result);
    }
}

class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (char c : columnTitle.toCharArray()) {
            res = res * 26 + (c - 'A' + 1);
        }
        return res;
    }
}