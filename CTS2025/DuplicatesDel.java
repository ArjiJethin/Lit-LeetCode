import java.util.*;

public class DuplicatesDel {
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

        void removeDuplicates() {
            Node tptr = head;
            int arr[] = new int[1000];

            for (int i = 0; i < 1000; i++) {
                arr[i] = 0;
            }

            while (tptr != null && tptr.next != null) {
                arr[tptr.data]++;
                if (arr[tptr.next.data] > 0) {
                    tptr.next = tptr.next.next;
                } else {
                    tptr = tptr.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL list = new SLL();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.addNode(sc.nextInt());
        }
        sc.close();

        System.out.println("Original List:");
        list.display();

        list.removeDuplicates();

        System.out.println("List after removing duplicates:");
        list.display();
    }

}
