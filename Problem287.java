public class Problem287 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 3, 4, 2, 2 };
        Solution solution = new Solution();
        int result = solution.findDuplicate(nums);
        System.out.println(result); // Expected output: 2
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int v : nums) {
                if (v <= mid) {
                    ++cnt;
                }
            }
            if (cnt > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}