import java.util.*;

public class MidPoint {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SLL {
        static Node head = null;

        static void addNode(int data) {
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

        static int MidPoint() {
            if (head == null) {
                System.out.println("List is empty");
                return -1;
            }

            Node tptr = head;
            Node fptr = head;

            while (fptr != null && fptr.next != null) {
                tptr = tptr.next;
                fptr = fptr.next.next;
            }

            return tptr.data;
        }

        static void display() {
            Node tptr = head;
            while (tptr != null) {
                System.out.print(tptr.data + " -> ");
                tptr = tptr.next;
            }
            System.out.println("null");
        }
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SLL list = new SLL();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            list.addNode(data);
        }

        System.out.println("Linked List:");
        list.display();

        int mid = list.MidPoint();
        if (mid != -1) {
            System.out.println("Mid Point: " + mid);
        }
        sc.close();

    }
}