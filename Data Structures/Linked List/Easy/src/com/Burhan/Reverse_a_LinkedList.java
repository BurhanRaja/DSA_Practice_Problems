package com.Burhan;

import com.Burhan.Detect_Loop_in_LinkedList.Node;

public class Reverse_a_LinkedList {
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(1);

        reverse(head);
    }

    static void reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
    }
}
