import java.util.ArrayList;
import java.util.List;

public class Problem349 {
    
    public static void main(String[] args) {
        // Example usage
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        IntersectionSolution solution = new IntersectionSolution();
        int[] result = solution.intersection(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

class IntersectionSolution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] s = new boolean[1001];
        for (int x : nums1) {
            s[x] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for (int x : nums2) {
            if (s[x]) {
                ans.add(x);
                s[x] = false;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}