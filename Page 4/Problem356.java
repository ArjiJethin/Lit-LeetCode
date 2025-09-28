import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Problem356 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 } };
        boolean result = solution.isReflected(points);
        System.out.println("Is reflected: " + result);
    }
}

class Solution {
    public boolean isReflected(int[][] points) {
        final int inf = 1 << 30;
        int minX = inf, maxX = -inf;
        Set<List<Integer>> pointSet = new HashSet<>();
        for (int[] p : points) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            pointSet.add(List.of(p[0], p[1]));
        }
        int s = minX + maxX;
        for (int[] p : points) {
            if (!pointSet.contains(List.of(s - p[0], p[1]))) {
                return false;
            }
        }
        return true;
    }
}