public class Problem278 {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int n = 5; // Total versions
        int firstBad = solution.firstBadVersion(n);
        System.out.println("First bad version: " + firstBad); // Expected output: the first bad version number
    }
}

class VersionControl {
    // Dummy implementation for compilation; replace with actual logic as needed
    boolean isBadVersion(int version) {
        // For example, let's say version 4 and onwards are bad
        return version >= 4;
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}