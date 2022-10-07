package com.Burhan;

import java.util.Stack;

import com.Burhan.Remove_Loop_LinkedList.Node;

public class Check_If_Palindrome {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(1);

        boolean ans = isPalindrome(head);
        System.out.println(ans);
    }

    static boolean isPalindrome(Node head) {
        boolean flag = false;
        Node curr = head;
        Node temp = head;

        Stack<Integer> s = new Stack<>();

        while (curr != null) {
            s.add(curr.data);
            curr = curr.next;
        }

        while (temp != null) {
            if (s.pop() == temp.data) {
                flag = true;
            }
            else {
                flag = false;
                break;
            }
            temp = temp.next;
        }
        return flag;
    }
}
