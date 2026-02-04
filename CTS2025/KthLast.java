import java.util.*;

public class KthLast {
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

        static void display() {
            Node tptr = head;
            while (tptr != null) {
                System.out.print(tptr.data + " -> ");
                tptr = tptr.next;
            }
            System.out.println("null");
        }

        static int KthLast(int k) {
            Node tptr = head;
            Node kptr = head;
            int count = 1;
            while (tptr != null) {
                if (count > k) {
                    kptr = kptr.next;
                }
                tptr = tptr.next;
                count++;
            }
            if (count <= k) {
                System.out.println("List has fewer than " + k + " elements.");
                return -1;
            }
            return kptr.data;
        }
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        SLL list = new SLL();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            list.addNode(num);
        }

        list.display();

        int k = sc.nextInt();
        int KthLast = list.KthLast(k);

        if (KthLast != -1) {
            System.out.println(k + "th last element is: " + KthLast);
        }
        sc.close();
    }
}
