import java.util.List;

import java.util.*;

public class Problem281 {
    public static void main(String[] args) {
        // Example usage
        List<Integer> v1 = List.of(1, 2);
        List<Integer> v2 = List.of(3, 4, 5);
        ZigzagIterator zigzagIterator = new ZigzagIterator(v1, v2);

        while (zigzagIterator.hasNext()) {
            System.out.print(zigzagIterator.next() + " ");
        }
    }

    // ZigzagIterator implementation
    static class ZigzagIterator {
        private Queue<Iterator<Integer>> queue;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            queue = new LinkedList<>();
            if (v1 != null && !v1.isEmpty())
                queue.offer(v1.iterator());
            if (v2 != null && !v2.isEmpty())
                queue.offer(v2.iterator());
        }

        public int next() {
            Iterator<Integer> it = queue.poll();
            int val = it.next();
            if (it.hasNext())
                queue.offer(it);
            return val;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}