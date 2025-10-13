import java.util.Map;
import java.util.HashMap;

public class Problem447 {
    public static void main(String[] args) {
        // Example usage
        int[][] points = { { 0, 0 }, { 1, 0 }, { 2, 0 } };
        Solution solution = new Solution();
        int result = solution.numberOfBoomerangs(points);
        System.out.println("Number of boomerangs: " + result); // Expected output: 2
    }
}

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p1 : points) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int[] p2 : points) {
                int d = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                cnt.merge(d, 1, Integer::sum);
            }
            for (int x : cnt.values()) {
                ans += x * (x - 1);
            }
        }
        return ans;
    }
}