public class Problem260 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 2, 1, 3, 2, 5 };
        Solution sol = new Solution();
        int[] result = sol.singleNumber(nums);
        System.out.println(result[0] + ", " + result[1]); // Should print the two unique numbers
    }
}

class Solution {
    public int[] singleNumber(int[] nums) {
        int xs = 0;
        for (int x : nums) {
            xs ^= x;
        }
        int lb = xs & -xs;
        int a = 0;
        for (int x : nums) {
            if ((x & lb) != 0) {
                a ^= x;
            }
        }
        int b = xs ^ a;
        return new int[] { a, b };
    }
}