import java.util.*;

public class Problem207 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage:
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(solution.canFinish(numCourses, prerequisites)); // Output: true
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int cnt = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            ++cnt;
            for (int j : g[i]) {
                if (--indeg[j] == 0) {
                    q.offer(j);
                }
            }
        }
        return cnt == numCourses;
    }
}