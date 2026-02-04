public class RotateSLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SLL {
        Node head = null;

        void addNode(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node tptr = head;
                while (tptr.next != null) {
                    tptr = tptr.next;
                }
                tptr.next = newNode;
            }
        }

        void display() {
            Node tptr = head;
            while (tptr != null) {
                System.out.print(tptr.data + " ->");
            }
            System.out.print("null\n");
        }

        void Rotate(Node head, int k) {
            if (head == null || head.next == null) {
                return;
            }

            Node last = head;
            int length = 1;

            while (last.next != null) {
                last = last.next;
                length++;
            }

            last.next = head; // Make it circular
            // Number of rotations
            k = k % length; // In case k is greater than length
            int stepsToNewHead = length - k;

            Node newTail = head;
            for (int i = 1; i < stepsToNewHead; i++) {
                newTail = newTail.next;
            }

            Node newHead = newTail.next;
            newTail.next = null; // Break the circle

            this.head = newHead; // Update head to new head
        }
    }
}
