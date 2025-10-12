import java.util.Arrays;
import java.util.Comparator;

public class Problem436 {
    public static void main(String[] args) {
        // Example usage
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        Solution solution = new Solution();
        int result = solution.eraseOverlapIntervals(intervals);
        System.out.println("Minimum number of intervals to remove: " + result); // Expected output: 1
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int t = intervals[0][1], ans = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] >= t) {
                t = intervals[i][1];
            } else {
                ++ans;
            }
        }
        return ans;
    }
}