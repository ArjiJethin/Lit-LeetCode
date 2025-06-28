public class Problem275 {
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
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (citations[n - mid] >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}