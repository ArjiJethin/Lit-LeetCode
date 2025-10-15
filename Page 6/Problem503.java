
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;

public class Problem503 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        Solution solution = new Solution();
        int[] result = solution.nextGreaterElements(nums);
        System.out.print("Next Greater Elements: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < (n << 1); ++i) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i % n]) {
                ans[stk.pop()] = nums[i % n];
            }
            stk.push(i % n);
        }
        return ans;
    }
}