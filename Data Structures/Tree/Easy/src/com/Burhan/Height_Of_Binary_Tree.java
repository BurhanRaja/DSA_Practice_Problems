package com.Burhan;

public class Height_Of_Binary_Tree {

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
        root.left.left = new Node(30);

        root.right = new Node(20);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.left.left = new Node(60);
        root.right.left.right = new Node(70);

        int ans = heightOfTree(root);
        System.out.println(ans);
    }

    static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        else {
            return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
        }
    }
}