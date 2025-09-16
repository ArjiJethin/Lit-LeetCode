
public class Problem137 {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 2 };
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(nums)); // Output: 3
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int c : nums) {
            int aa = (~a & b & c) | (a & ~b & ~c);
            int bb = ~a & (b ^ c);
            a = aa;
            b = bb;
        }
        return b;
    }
}