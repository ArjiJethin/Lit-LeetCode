import java.util.HashMap;
import java.util.Map;

public class Problem325 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, -1, 5, -2, 3 };
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.maxSubArrayLen(nums, k)); // Output: 4
    }
}

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Long, Integer> d = new HashMap<>();
        d.put(0L, -1);
        int ans = 0;
        long s = 0;
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i];
            ans = Math.max(ans, i - d.getOrDefault(s - k, i));
            d.putIfAbsent(s, i);
        }
        return ans;
    }
}