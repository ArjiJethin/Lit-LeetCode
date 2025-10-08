public class Problem410 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 7, 2, 5, 10, 8 };
        int k = 2;
        Solution solution = new Solution();
        int result = solution.splitArray(nums, k);
        System.out.println(result); // Expected output: 18
    }
}

class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int x : nums) {
            left = Math.max(left, x);
            right += x;
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int mx, int k) {
        int s = 1 << 30, cnt = 0;
        for (int x : nums) {
            s += x;
            if (s > mx) {
                ++cnt;
                s = x;
            }
        }
        return cnt <= k;
    }
}