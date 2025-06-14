import java.util.*;

public class Problem210 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage:
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
        int[] order = solution.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order)); // Output: [0, 1, 2, 3] or similar valid order
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        @SuppressWarnings("unchecked")
        List<Integer>[] g = (List<Integer>[]) new List[numCourses];
        Arrays.setAll(g, _ -> new ArrayList<>());
        int[] indeg = new int[numCourses];
        for (var p : prerequisites) {
            int a = p[0], b = p[1];
            g[b].add(a);
            ++indeg[a];
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        int[] ans = new int[numCourses];
        int cnt = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            ans[cnt++] = i;
            for (int j : g[i]) {
                if (--indeg[j] == 0) {
                    q.offer(j);
                }
            }
        }
        return cnt == numCourses ? ans : new int[0];
    }
}