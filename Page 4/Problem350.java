import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Problem350 {
    public static void main(String[] args) {
        // Example usage
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        Solution solution = new Solution();
        int[] result = solution.intersect(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums1) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        List<Integer> t = new ArrayList<>();
        for (int num : nums2) {
            if (counter.getOrDefault(num, 0) > 0) {
                t.add(num);
                counter.put(num, counter.get(num) - 1);
            }
        }
        int[] res = new int[t.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = t.get(i);
        }
        return res;
    }
}