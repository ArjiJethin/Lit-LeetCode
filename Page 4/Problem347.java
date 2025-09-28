import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class Problem347 {

}

class Solution_official_oN {
    int[] unique;
    Map<Integer, Integer> count;

    public void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }

    public int partition(int left, int right, int pivot_index) {
        int pivot_frequency = count.get(unique[pivot_index]);
        // 1. move pivot to end
        swap(pivot_index, right);
        int store_index = left;

        // 2. move all less frequent elements to the left
        for (int i = left; i <= right; i++) {
            if (count.get(unique[i]) < pivot_frequency) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(store_index, right);

        return store_index;
    }

    public void quickselect(int left, int right, int k_smallest) {
        /*
         * Sort a list within left..right till kth less frequent element
         * takes its place.
         */

        // base case: the list contains only one element
        if (left == right)
            return;

        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        // find the pivot position in a sorted list
        pivot_index = partition(left, right, pivot_index);

        // if the pivot is in its final sorted position
        if (k_smallest == pivot_index) {
            return;
        } else if (k_smallest < pivot_index) {
            // go left
            quickselect(left, pivot_index - 1, k_smallest);
        } else {
            // go right
            quickselect(pivot_index + 1, right, k_smallest);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // array of unique elements
        int n = count.size();
        unique = new int[n];
        int i = 0;
        for (int num : count.keySet()) {
            unique[i] = num;
            i++;
        }

        // kth top frequent element is (n - k)th less frequent.
        // Do a partial sort: from less frequent to the most frequent, till
        // (n - k)th less frequent element takes its place (n - k) in a sorted array.
        // All element on the left are less frequent.
        // All the elements on the right are more frequent.
        quickselect(0, n - 1, n - k);
        // Return top k frequent elements
        return Arrays.copyOfRange(unique, n - k, n);
    }
}

class Solution_optimize {
    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first', poll到最后剩下K个最大的
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> countMap.get(n1) - countMap.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n : countMap.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}

// use an array to save numbers into different bucket whose index is the
// frequency
class Solution_bucketCount {
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> result = new LinkedList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> hm = new HashMap<>();
        for (int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        // @note: corner case: if there is only one number in nums, we need the bucket
        // has index 1.
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] bucket = (LinkedList<Integer>[]) new LinkedList[nums.length + 1];

        for (int n : hm.keySet()) {
            int freq = hm.get(n);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(n);
        }

        for (int i = bucket.length - 1; i > 0 && k > 0; i--) {

            // @note: possible tie happening
            if (bucket[i] != null) {
                List<Integer> list = bucket[i];
                result.addAll(list);
                k -= list.size();
            }
        }

        return result;
    }
}

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        // from num, to its count
        HashMap<Integer, Integer> hm = new HashMap<>();

        // to store top k
        PriorityQueue<Pair> heap = new PriorityQueue<>(
                (o1, o2) -> (o1.count - o2.count));

        for (int each : nums) {
            hm.put(each, 1 + hm.getOrDefault(each, 0));
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            heap.offer(new Pair(entry.getKey(), entry.getValue()));

            // @note: i missed it
            if (heap.size() > k) {
                heap.poll();
            }
        }

        while (!heap.isEmpty()) {
            result.add(heap.poll().num);
        }

        Collections.reverse(result);

        return result;
    }
}

class Pair {
    int num;
    int count;

    public Pair(int num, int count) {
        this.num = num;
        this.count = count;
    }
}