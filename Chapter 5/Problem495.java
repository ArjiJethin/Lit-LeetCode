public class Problem495 {
    public static void main(String[] args) {
        // Example usage
        int[] timeSeries = { 1, 4, 5 };
        int duration = 2;
        Solution solution = new Solution();
        int result = solution.findPoisonedDuration(timeSeries, duration);
        System.out.println("Total poisoned duration: " + result); // Expected output: 4
    }
}

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int ans = duration;
        for (int i = 1; i < n; ++i) {
            ans += Math.min(duration, timeSeries[i] - timeSeries[i - 1]);
        }
        return ans;
    }
}