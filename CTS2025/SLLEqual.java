import java.util.*;

public class SLLEqual {
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
                System.out.print(tptr.data + " -> ");
                tptr = tptr.next;
            }
            System.out.println("null");
        }

        static boolean areEqual(Node h1, Node h2) {
            while (h1 != null && h2 != null) {
                if (h1.data != h2.data) {
                    return false;
                }
                h1 = h1.next;
                h2 = h2.next;
            }
            return (h1 == null && h2 == null);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL list1 = new SLL();
        SLL list2 = new SLL();

        System.out.println("Enter number of elements for first list:");
        int n1 = sc.nextInt();
        System.out.println("Enter elements for first list:");
        for (int i = 0; i < n1; i++) {
            list1.addNode(sc.nextInt());
        }

        System.out.println("Enter number of elements for second list:");
        int n2 = sc.nextInt();
        System.out.println("Enter elements for second list:");
        for (int i = 0; i < n2; i++) {
            list2.addNode(sc.nextInt());
        }

        sc.close();

        boolean result = SLL.areEqual(list1.head, list2.head);
        System.out.println("The two linked lists are equal: " + result);
    }
}
