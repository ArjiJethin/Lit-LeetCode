import java.util.Arrays;
import java.util.Comparator;

public class Problem452 {
    public static void main(String[] args) {
        // Example usage
        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        Solution solution = new Solution();
        int result = solution.findMinArrowShots(points);
        System.out.println("Minimum number of arrows needed: " + result); // Expected output: 2
    }
}

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        long last = -(1L << 60);
        for (var p : points) {
            int a = p[0], b = p[1];
            if (a > last) {
                ++ans;
                last = b;
            }
        }
        return ans;
    }
}