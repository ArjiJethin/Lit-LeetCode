import java.util.Arrays;

public class Problem252 {
    public static void main(String[] args) {
        // Example usage
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        Solution solution = new Solution();
        boolean result = solution.canAttendMeetings(intervals);
        System.out.println("Can attend all meetings: " + result); // Should print false
    }
}

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; ++i) {
            var a = intervals[i - 1];
            var b = intervals[i];
            if (a[1] > b[0]) {
                return false;
            }
        }
        return true;
    }
}