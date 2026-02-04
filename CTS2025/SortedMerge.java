import java.util.*;

public class SortedMerge {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SLL {
        Node head;

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

        static Node SortMerge(Node h1, Node h2) {
            Node dummy = new Node(0);
            Node tail = dummy;

            while (h1 != null && h2 != null) {
                if (h1.data <= h2.data) {
                    tail.next = h1;
                    h1 = h1.next;
                } else {
                    tail.next = h2;
                    h2 = h2.next;
                }
                tail = tail.next;
            }
            tail.next = (h1 != null) ? h1 : h2;
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SLL list1 = new SLL();
        SLL list2 = new SLL();

        System.out.println("Enter number of elements in first sorted list:");
        int n1 = sc.nextInt();
        System.out.println("Enter elements of first sorted list:");
        for (int i = 0; i < n1; i++) {
            int num = sc.nextInt();
            list1.addNode(num);
        }

        System.out.println("Enter number of elements in second sorted list:");
        int n2 = sc.nextInt();
        System.out.println("Enter elements of second sorted list:");
        for (int i = 0; i < n2; i++) {
            int num = sc.nextInt();
            list2.addNode(num);
        }

        Node mergedHead = SLL.SortMerge(list1.head, list2.head);

        System.out.println("Merged Sorted List:");
        SLL mergedList = new SLL();
        mergedList.head = mergedHead;
        mergedList.display();

        sc.close();
    }
}