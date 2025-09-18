
public class Problem168 {
    public static void main(String[] args) {
        int columnNumber = 28;
        Solution solution = new Solution();
        String result = solution.convertToTitle(columnNumber);
        System.out.println("Column title: " + result);
    }
}

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber != 0) {
            --columnNumber;
            res.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }
}