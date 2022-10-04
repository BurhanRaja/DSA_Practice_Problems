package com.Burhan;

import java.util.LinkedList;
import java.util.Queue;

public class Print_Left_View_Of_Tree {

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int k) {
            key = k;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(15);

        root.right = new Node(20);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.left.left = new Node(60);
        root.right.left.right = new Node(70);

        printLeft(root);
    }

    // Recursive
    static int maxLevel = 0;
    static void leftView(Node root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.print(root.key + " ");
            maxLevel = level;
        }
        leftView(root.left, level+1);
        leftView(root.right, level+1);
    }

    // Iterative
    static void printLeft(Node root) {
        if (root == null) {
            return;
        }
        else {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int count = q.size();

                for (int i = 0; i < count; i++) {

                    Node curr = q.poll();
                    if (i == 0) {
                        System.out.print(root.key + " ");
                    }
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
                
            }
        }
    }
}