public class Problem476 {
    public static void main(String[] args) {
        // Example usage
        int num = 5;
        Solution solution = new Solution();
        int result = solution.findComplement(num);
        System.out.println("Complement of " + num + ": " + result); // Expected output: 2
    }
}

class Solution {
    public int findComplement(int num) {
        int ans = 0;
        boolean find = false;
        for (int i = 30; i >= 0; --i) {
            int b = num & (1 << i);
            if (!find && b == 0) {
                continue;
            }
            find = true;
            if (b == 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}