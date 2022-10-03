package com.Burhan;

import com.Burhan.Height_Of_Binary_Tree.Node;

public class Size_Of_Binary_Tree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(15);
        root.left.left = new Node(30);

        root.right = new Node(20);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        root.right.left.left = new Node(60);
        root.right.left.right = new Node(70);

        int ans = sizeOfTree(root);
        System.out.println(ans);
    }

    static int sizeOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        else{
            return 1+sizeOfTree(root.left) + sizeOfTree(root.right);
        }
    }
}
