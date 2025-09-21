public class Problem253 {
    public static void main(String[] args) {
        // Example usage
        int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        Solution solution = new Solution();
        int result = solution.minMeetingRooms(intervals);
        System.out.println(result); // Expected output: 2
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = 1000010;
        int[] delta = new int[n];
        for (int[] e : intervals) {
            ++delta[e[0]];
            --delta[e[1]];
        }
        int res = delta[0];
        for (int i = 1; i < n; ++i) {
            delta[i] += delta[i - 1];
            res = Math.max(res, delta[i]);
        }
        return res;
    }
}