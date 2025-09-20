import java.util.TreeSet;

public class Problem220 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 5, 9, 1, 5, 9 };
        int indexDiff = 2;
        int valueDiff = 3;
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff)); // Output: false
    }
}

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            Long x = ts.ceiling((long) nums[i] - (long) valueDiff);
            if (x != null && x <= (long) nums[i] + (long) valueDiff) {
                return true;
            }
            ts.add((long) nums[i]);
            if (i >= indexDiff) {
                ts.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}