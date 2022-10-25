import java.util.LinkedList;
import java.util.Queue;

public class Insert_BST {

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int k) {
            this.key = k;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.right = new Node(70);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        root.right.left.left = new Node(56);
        root.right.left.right = new Node(65);

        insertBST(root, 38);
        levelOrderTrav(root);
    }

    static void levelOrderTrav(Node root) {
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
                    System.out.print(curr.key + " ");
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }

                if (q.size() > 0) {
                    System.out.println();
                }
            }
        }
    }

    static Node insertBST(Node root, int x) {
        if (root == null) {
            return new Node(x);
        }

        if (root.key > x) {
            root.left = insertBST(root.left, x);
        } else {
            root.right = insertBST(root.right, x);
        }

        return root;
    }
}
