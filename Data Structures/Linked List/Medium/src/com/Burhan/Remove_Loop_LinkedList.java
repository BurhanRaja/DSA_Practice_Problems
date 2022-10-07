package com.Burhan;

import java.util.HashSet;

public class Remove_Loop_LinkedList {

    static class Node {
        int data;
        Node next;

        Node (int key) {
            this.data = key;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;

        removeLoop(head);
    }


    static void removeLoop(Node head) {
        HashSet<Node> hset = new HashSet<>();
        Node prev = null;
        while (head != null) {

            if (hset.contains(head)) {
                prev.next = null;
                System.out.println(1);
                break;
            }
            else {
                hset.add(head);
                prev = head;
                head = head.next;
            }
        }
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
    }


}