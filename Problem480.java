import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Problem480 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        Solution solution = new Solution();
        double[] result = solution.medianSlidingWindow(nums, k);
        System.out.print("Medians: ");
        for (double median : result) {
            System.out.print(median + " ");
        }
        // Expected output: "Medians: 1.0 3.0 3.0 5.0 6.0"
    }
}

class MedianFinder {
    private PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private Map<Integer, Integer> delayed = new HashMap<>();
    private int smallSize;
    private int largeSize;
    private int k;

    public MedianFinder(int k) {
        this.k = k;
    }

    public void addNum(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            ++smallSize;
        } else {
            large.offer(num);
            ++largeSize;
        }
        rebalance();
    }

    public double findMedian() {
        return (k & 1) == 1 ? small.peek() : ((double) small.peek() + large.peek()) / 2;
    }

    public void removeNum(int num) {
        delayed.merge(num, 1, Integer::sum);
        if (num <= small.peek()) {
            --smallSize;
            if (num == small.peek()) {
                prune(small);
            }
        } else {
            --largeSize;
            if (num == large.peek()) {
                prune(large);
            }
        }
        rebalance();
    }

    private void prune(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty() && delayed.containsKey(pq.peek())) {
            if (delayed.merge(pq.peek(), -1, Integer::sum) == 0) {
                delayed.remove(pq.peek());
            }
            pq.poll();
        }
    }

    private void rebalance() {
        if (smallSize > largeSize + 1) {
            large.offer(small.poll());
            --smallSize;
            ++largeSize;
            prune(small);
        } else if (smallSize < largeSize) {
            small.offer(large.poll());
            --largeSize;
            ++smallSize;
            prune(large);
        }
    }
}

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        MedianFinder finder = new MedianFinder(k);
        for (int i = 0; i < k; ++i) {
            finder.addNum(nums[i]);
        }
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        ans[0] = finder.findMedian();
        for (int i = k; i < n; ++i) {
            finder.addNum(nums[i]);
            finder.removeNum(nums[i - k]);
            ans[i - k + 1] = finder.findMedian();
        }
        return ans;
    }
}