import java.util.Set;
import java.util.HashSet;

public class Problem217 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(solution.containsDuplicate(nums)); // Output: true
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (!s.add(num)) {
                return true;
            }
        }
        return false;
    }
}