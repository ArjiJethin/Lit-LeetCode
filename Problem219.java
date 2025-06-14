import java.util.*;

public class Problem219 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 2, 3, 1 };
        int k = 3;
        System.out.println(solution.containsNearbyDuplicate(nums, k)); // Output: true
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i - d.getOrDefault(nums[i], -1000000) <= k) {
                return true;
            }
            d.put(nums[i], i);
        }
        return false;
    }
}