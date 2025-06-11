
public class Problem136 {
    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(nums)); // Output: 4
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int v : nums) {
            ans ^= v;
        }
        return ans;
    }
}