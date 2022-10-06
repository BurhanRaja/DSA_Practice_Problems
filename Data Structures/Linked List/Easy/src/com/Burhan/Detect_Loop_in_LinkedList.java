package com.Burhan;

public class Detect_Loop_in_LinkedList {

    static class Node {
        int data;
        Node next;

        Node (int d) {
            this.data = d;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = head;

        boolean ans = detectLoop(head);
        System.out.println(ans);

    }

    static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.data == fast.data) {
                return true;
            }
        }
        return false;
    }
    
    static boolean detectLoop2(Node head) {
        Node curr = head;
        while (curr.next != null && curr != null) {
            if (curr.data == 1) {
                return true;
            }
            curr.data = 1;
            curr = curr.next;
        }
        return false;
    }
}