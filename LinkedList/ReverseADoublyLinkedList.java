package LinkedList;

import java.util.Random;
import java.util.Scanner;

public class ReverseADoublyLinkedList {
    public static void main(String[] args) {

        String str = "1234";
        System.out.println(str.substring(str.length()-5));

        DNode head = new DNode(10);
        Scanner in = new Scanner(System.in);

        Random rand = new Random();

        head = insertAtBeginDL(head, rand.nextInt(100));
        head = insertAtBeginDL(head, rand.nextInt(100));
        head = insertAtBeginDL(head, rand.nextInt(100));

        printDoublyLinkedList(head);
        System.out.println();
        reverseDoublyLinkedList(head);
        head = reverseDoublyLinkedListNew(head);
        printDoublyLinkedList(head);

    }

    static DNode reverseDoublyLinkedListNew(DNode head) {
        if (head == null || head.next == null) return null;

        DNode curr = head, prev = null;

        while (curr != null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;

            curr = curr.prev;
        }
        return prev.prev;
    }

    static void reverseDoublyLinkedList(DNode head) {
        if (head == null) return;

        DNode last = head;
        DNode first = head;

        int l = 0, h = 0;

        while (last.next != null) {
            last = last.next;
            h++;
        }

        while (l < h) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
            first = first.next;
            last = last.prev;
            l++;
            h--;
        }
    }

    static void printDoublyLinkedList(DNode head) {
        DNode curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    static DNode insertAtBeginDL(DNode head, int x) {
        DNode temp = new DNode(x);

        if (head == null) return temp;

        DNode curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }



        curr.next = temp;
        temp.prev = curr;

        return head;
    }
}
