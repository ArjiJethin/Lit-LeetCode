public class Problem274 {
    public static void main(String[] args) {
        // Example usage
        int[] citations = { 3, 0, 6, 1, 5 };
        Solution solution = new Solution();
        int result = solution.hIndex(citations);
        System.out.println(result); // Expected output: 3
    }
}

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] cnt = new int[n + 1];
        for (int x : citations) {
            ++cnt[Math.min(x, n)];
        }
        for (int h = n, s = 0;; --h) {
            s += cnt[h];
            if (s >= h) {
                return h;
            }
        }
    }
}