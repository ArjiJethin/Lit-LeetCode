
public class Problem504 {
    public static void main(String[] args) {
        int num = -7;
        Solution solution = new Solution();
        String result = solution.convertToBase7(num);
        System.out.println("Base 7 Representation: " + result);
    }
}

class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        if (num < 0) {
            return "-" + convertToBase7(-num);
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        return sb.reverse().toString();
    }
}