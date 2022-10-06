package com.Burhan;

import com.Burhan.Detect_Loop_in_LinkedList.Node;

public class Finding_Middle_of_LinkedList {
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(6);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(5);
        
        head.next.next.next.next.next = new Node(1);
        // head.next.next.next.next.next.next = new Node(7);
        // head.next.next.next.next.next.next.next = new Node(8);
        // head.next.next.next.next.next.next.next.next = new Node(9);

        int ans = mid(head);
        System.out.println(ans);
    }

    static int mid(Node head) {
        Node curr = head;
        Node temp = head;
        int len = 0;

        while (curr != null) {
            curr = curr.next;
            len++;
        }

        int midLen = len/2;

        for (int i = 0; i < midLen; i++) {
            temp = temp.next;
        }

        return temp.data;
    }
}
