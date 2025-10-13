import java.util.List;
import java.util.Arrays;

public class Problem469 {
    public static void main(String[] args) {
        // Example usage
        List<List<Integer>> points = Arrays.asList(
                Arrays.asList(0, 0),
                Arrays.asList(1, 1),
                Arrays.asList(1, 0),
                Arrays.asList(0, 1));
        Solution solution = new Solution();
        boolean result = solution.isConvex(points);
        System.out.println("Is the polygon convex? " + result); // Expected output: true
    }
}

class Solution {
    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        long pre = 0, cur = 0;
        for (int i = 0; i < n; ++i) {
            var p1 = points.get(i);
            var p2 = points.get((i + 1) % n);
            var p3 = points.get((i + 2) % n);
            int x1 = p2.get(0) - p1.get(0);
            int y1 = p2.get(1) - p1.get(1);
            int x2 = p3.get(0) - p1.get(0);
            int y2 = p3.get(1) - p1.get(1);
            cur = x1 * y2 - x2 * y1;
            if (cur != 0) {
                if (cur * pre < 0) {
                    return false;
                }
                pre = cur;
            }
        }
        return true;
    }
}