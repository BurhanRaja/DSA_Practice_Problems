package com.Burhan;

public class Children_Sum_property {

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int k) {
            key = k;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);

        root.right = new Node(12);
        root.right.left = new Node(3);
        root.right.right = new Node(9);

        boolean ans = childSum(root);
        System.out.println(ans);
    }

    static boolean childSum(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        int sum = 0;
        if (root.left != null) {
            sum += root.left.key;
        }
        if (root.right != null) {
            sum += root.right.key;
        }

        return (root.key == sum && childSum(root.left) && childSum(root.right));
        
    }
}
