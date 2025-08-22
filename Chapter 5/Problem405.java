public class Problem405 {
    public static void main(String[] args) {
        // Example usage
        int num = 26;
        Solution solution = new Solution();
        String result = solution.toHex(num);
        System.out.println(result); // Expected output: "1a"
    }
}

class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int x = num & 15;
            if (x < 10) {
                sb.append(x);
            } else {
                sb.append((char) (x - 10 + 'a'));
            }
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}