public class Problem201 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rangeBitwiseAnd(5, 7)); // Output: 4
        System.out.println(solution.rangeBitwiseAnd(0, 1)); // Output: 0
    }
}

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right &= (right - 1);
        }
        return right;
    }
}