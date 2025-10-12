public class Problem430 {
    public static void main(String[] args) {
        // Example usage
        Node head = new Node(1);
        head.child = new Node(2);
        head.next = new Node(3);
        head.next.child = new Node(4);
        Solution solution = new Solution();
        Node flattenedHead = solution.flatten(head);
        while (flattenedHead != null) {
            System.out.print(flattenedHead.val + " ");
            flattenedHead = flattenedHead.next;
        }
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }
}

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node();
        dummy.next = head;
        preorder(dummy, head);
        dummy.next.prev = null;
        return dummy.next;
    }

    private Node preorder(Node pre, Node cur) {
        if (cur == null) {
            return pre;
        }
        cur.prev = pre;
        pre.next = cur;

        Node t = cur.next;
        Node tail = preorder(cur, cur.child);
        cur.child = null;
        return preorder(tail, t);
    }
}