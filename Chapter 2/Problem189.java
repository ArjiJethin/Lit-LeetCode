import java.util.*;

public class Problem189 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums)); // Output: [5, 6, 7, 1, 2, 3, 4]
    }
}

class Solution {
    private int[] nums;

    public void rotate(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;
        k %= n;
        reverse(0, n - 1);
        reverse(0, k - 1);
        reverse(k, n - 1);
    }

    private void reverse(int i, int j) {
        for (; i < j; ++i, --j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}