import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Objects;

public class Problem23 {
    public static void main(String[] args) {
        Solution_Heap solution = new Solution_Heap();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = { list1, list2, list3 };
        ListNode result = solution.mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution_Heap {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        Arrays.stream(lists)
                .filter(Objects::nonNull)
                .forEach(heap::offer);

        while (!heap.isEmpty()) {
            ListNode polled = heap.poll();
            current.next = polled;
            current = current.next;
            if (polled.next != null) {
                heap.offer(polled.next);
            }
        }

        return dummy.next;
    }
}
