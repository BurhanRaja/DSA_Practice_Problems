public class Search_BST {

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

        boolean ans = searchBST(root, 65);
        System.out.println(ans);
    }

    static boolean searchBST(Node root, int x) {
        while (root != null) {
            if (root.key == x) {
                return true;
            } else if (root.key < x) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return false;
    }
}
