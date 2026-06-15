1class Solution {
2    public ListNode deleteMiddle(ListNode head) {
3        if (head.next == null) return null;
4
5        ListNode slow = head;
6        ListNode fast = slow.next.next;
7
8        while (fast != null && fast.next != null) {
9            slow = slow.next;
10            fast = fast.next.next;
11        }
12
13        slow.next = slow.next.next;
14        return head;
15    }
16}