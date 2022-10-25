

public class Postorder_Traversal {

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int k) {
            this.key = k;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.left.left = new Node(5);
        root.left.right = new Node(30);

        root.right = new Node(35);
        root.right.left = new Node(25);
        root.right.right = new Node(40);

        postOrderTraversal(root);
    }

    static void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.key + " ");
        }
    }
}
