package com.Burhan;

public class Nth_Node_from_end {

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
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);

        int ans = nthNode2(head, 2);
        System.out.println(ans);

        // Node ans = deleteNode(head, 3);
        // System.out.println(ans.data);
    }

    static int nthNode(Node head, int n) {
        Node curr = head;
        while (curr != null) {
            Node prev = curr;
            int count = n-1;
            while (count != 0) {
                curr = curr.next;
                if (curr == null) {
                    return -1;
                }
                count--;
            }
            if (curr.next == null) {
                return prev.data;
            }
            curr = prev;
            curr = curr.next;
        }

        return -1;
    }

    static Node deleteNode(Node head, int num) {
        Node curr = head;
        for (int i = 1; i < num; i++) {
            curr = curr.next;
        }
        return curr;
    }

    static int nthNode2(Node head, int n) {
        Node curr = head;

        int totalCount = 0;
        while (curr != null) {
            curr = curr.next;
            totalCount++;
        }

        if (totalCount < n) {
            return -1;
        }

        Node temp = deleteNode(head, totalCount-n+1);

        return temp.data;
    }
}
