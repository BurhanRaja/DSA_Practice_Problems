import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder_Traversal {

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

        levelOrderTraversal(root);
    }

    static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        } else {
            Queue<Node> q = new LinkedList<>();

            q.add(root);

            while (!q.isEmpty()) {
                Node curr = q.poll();
                System.out.print(curr.key + " ");

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
