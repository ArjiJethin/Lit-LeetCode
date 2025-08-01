import java.util.Deque;
import java.util.ArrayDeque;

public class Problem456 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 2, 3, 4 };
        Solution solution = new Solution();
        boolean result = solution.find132pattern(nums);
        System.out.println("Contains 132 pattern: " + result); // Expected output: false
    }
}

class Solution {
    public boolean find132pattern(int[] nums) {
        int vk = -(1 << 30);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] < vk) {
                return true;
            }
            while (!stk.isEmpty() && stk.peek() < nums[i]) {
                vk = stk.pop();
            }
            stk.push(nums[i]);
        }
        return false;
    }
}