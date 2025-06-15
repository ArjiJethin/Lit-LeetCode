import java.util.*;

public class Problem239 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        Solution solution = new Solution();
        int[] result = solution.maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0, j = 0; i < n; ++i) {
            if (!q.isEmpty() && i - k + 1 > q.peekFirst()) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k - 1) {
                ans[j++] = nums[q.peekFirst()];
            }
        }
        return ans;
    }
}