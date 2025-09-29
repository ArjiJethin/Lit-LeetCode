import java.util.*;

public class Problem373 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = { 1, 7, 11 };
        int[] nums2 = { 2, 4, 6 };
        int k = 3;
        List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);
        System.out.println(result);
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < Math.min(nums1.length, k); ++i) {
            q.offer(new int[] { nums1[i] + nums2[0], i, 0 });
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty() && k > 0) {
            int[] e = q.poll();
            ans.add(Arrays.asList(nums1[e[1]], nums2[e[2]]));
            --k;
            if (e[2] + 1 < nums2.length) {
                q.offer(new int[] { nums1[e[1]] + nums2[e[2] + 1], e[1], e[2] + 1 });
            }
        }
        return ans;
    }
}