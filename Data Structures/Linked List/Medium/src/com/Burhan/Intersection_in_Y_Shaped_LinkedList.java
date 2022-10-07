package com.Burhan;

import com.Burhan.Remove_Loop_LinkedList.Node;

public class Intersection_in_Y_Shaped_LinkedList {
    public static void main(String[] args) {
//         3 6 5
// 63 96 55
// 65 61 78 51 48 11
// 98 30 94 19 48

        Node head1 = new Node(63);
        head1.next = new Node(96);
        head1.next.next = new Node(55);

        Node head2 = new Node(65);
        head2.next = new Node(61);
        head2.next.next = new Node(78);
        head2.next.next.next = new Node(51);
        head2.next.next.next.next = new Node(48);
        head2.next.next.next.next.next = new Node(11);

        Node common = new Node(98);
        common.next = new Node(30);
        common.next.next = new Node(94);
        common.next.next.next = new Node(19);
        common.next.next.next.next = new Node(48);

        head1.next.next.next = common;
        head2.next.next.next.next.next.next = common;

        intersection2(head1, head2);
    }

    static void intersection(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        int len1 = 0;
        int len2 = 0;

        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }


        if (len1 > len2) {
            int len = len1 - len2;
            while (len != 0) {
                head1 = head1.next;
                len--;
            }

            while (head1 != null && head2 != null) {
                if (head1 == head2) {
                    System.out.println(head1.data);
                    break;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        else {
            int len = len2 - len1;
            while (len != 0) {
                head2 = head2.next;
                len--;
            }

            while (head1 != null && head2 != null) {
                if (head1 == head2) {
                    System.out.println(head1.data);
                    break;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }


    // Efficient
    static void intersection2(Node head1, Node head2) {
        while (head1 != null) {
            head1.data *= -1;
            head1 = head1.next;
        }

        while (head2 != null) {
            if (head2.data < 0) {
                System.out.print(head2.data*(-1));
                break;
            }
            head2 = head2.next;
        }
    }
}
