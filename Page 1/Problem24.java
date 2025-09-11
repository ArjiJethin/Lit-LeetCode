public class Problem24 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result = solution.swapPairs(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {
            ListNode first = pre.next;
            ListNode second = first.next;

            // Swapping
            first.next = second.next;
            second.next = first;
            pre.next = second;

            // Move to the next pair
            pre = first;
        }

        return dummy.next;
    }
}
