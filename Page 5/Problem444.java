import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class Problem444 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> sequences = List.of(
                List.of(1, 2),
                List.of(1, 3),
                List.of(2, 3));
        Solution solution = new Solution();
        boolean result = solution.sequenceReconstruction(nums, sequences);
        System.out.println("Can reconstruct: " + result); // Expected output: true
    }
}

class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        int[] indeg = new int[n];
        @SuppressWarnings("unchecked")
        List<Integer>[] g = (List<Integer>[]) new List[n];
        Arrays.setAll(g, _ -> new ArrayList<>());
        for (var seq : sequences) {
            for (int i = 1; i < seq.size(); ++i) {
                int a = seq.get(i - 1) - 1, b = seq.get(i) - 1;
                g[a].add(b);
                indeg[b]++;
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            if (q.size() > 1) {
                return false;
            }
            int i = q.poll();
            for (int j : g[i]) {
                if (--indeg[j] == 0) {
                    q.offer(j);
                }
            }
        }
        return true;
    }
}