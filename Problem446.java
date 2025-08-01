import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Problem446 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 2, 3, 4, 5 };
        Solution solution = new Solution();
        int result = solution.numberOfArithmeticSlices(nums);
        System.out.println("Number of arithmetic slices: " + result); // Expected output: 6
    }
}

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        @SuppressWarnings("unchecked")
        Map<Long, Integer>[] f = (Map<Long, Integer>[]) new Map[n];
        Arrays.setAll(f, _ -> new HashMap<>());
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                Long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].merge(d, cnt + 1, Integer::sum);
            }
        }
        return ans;
    }
}