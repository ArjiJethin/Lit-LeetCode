public class Problem246 {
    public static void main(String[] args) {
        // Example usage
        String num = "69";
        Solution solution = new Solution();
        boolean result = solution.isStrobogrammatic(num);
        System.out.println(result); // Expected output: true
    }
}

class Solution {
    public boolean isStrobogrammatic(String num) {
        int[] d = new int[] { 0, 1, -1, -1, -1, -1, 9, -1, 8, 6 };
        for (int i = 0, j = num.length() - 1; i <= j; ++i, --j) {
            int a = num.charAt(i) - '0', b = num.charAt(j) - '0';
            if (d[a] != b) {
                return false;
            }
        }
        return true;
    }
}