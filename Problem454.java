import java.util.Map;
import java.util.HashMap;

public class Problem454 {
    public static void main(String[] args) {
        // Example usage
        int[] nums1 = { 1, 2 };
        int[] nums2 = { -2, -1 };
        int[] nums3 = { -1, 2 };
        int[] nums4 = { 0, 2 };
        Solution solution = new Solution();
        int result = solution.fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println("Number of tuples: " + result); // Expected output: 2
    }
}

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                counter.put(a + b, counter.getOrDefault(a + b, 0) + 1);
            }
        }
        int ans = 0;
        for (int c : nums3) {
            for (int d : nums4) {
                ans += counter.getOrDefault(-(c + d), 0);
            }
        }
        return ans;
    }
}