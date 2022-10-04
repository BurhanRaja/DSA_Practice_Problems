package com.Burhan;

import com.Burhan.Children_Sum_property.Node;

public class Check_for_Balanced_Tree {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(12);
        root.left.left = new Node(13);
        root.left.right = new Node(14);

        root.right = new Node(15);
        root.right.right = new Node(16);
        root.right.right.right = new Node(17);

        boolean ans = isBalanced(root);
        System.out.println(ans);

        // 
        int ans2 = isBalanced2(root);
        if (ans2 == heightOfTree(root)) {
            System.out.print(true);
        }
        else {
            System.out.print(false);
        }
    }

    static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    // O(n^2)
    static boolean isBalanced(Node root) {
        if(root == null) {
            return true;
        }
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);

        return ((Math.abs(lh-rh) <= 1) && isBalanced(root.left) && isBalanced(root.right));
    }

    // O(n)
    static int isBalanced2(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = isBalanced2(root.left);
        if (lh == -1) {
            return -1;
        }

        int rh = isBalanced2(root.right);
        if (rh == -1) {
            return -1;
        }

        if (Math.abs(lh-rh) > 1) {
            return -1;
        }
        else {
            return Math.max(lh, rh) + 1;
        }
    }

}
