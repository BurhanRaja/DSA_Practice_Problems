public class Delete_BST {

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
        root.right.right.right = new Node(90);
        root.right.right.left = new Node(75);
        root.right.left.left = new Node(56);
        root.right.left.right = new Node(65);

        Node ans = deleteBST(root, 70);
        inorderTraversal(ans);
    }

    static Node deleteBST(Node root, int x) {
        if (root == null) {
            return null;
        }
        if (root.key > x) {
            root.left = deleteBST(root.left, x);
        } 
        else if (root.key < x) {
            root.right = deleteBST(root.right, x);
        } 
        else {
            if (root.left == null) {
                return root.right;
            } 
            else if (root.right == null) {
                return root.left;
            } 
            else {
                Node successor = getSuccessor(root);
                root.key = successor.key;
                root.right = deleteBST(root.right, successor.key);
            }
        }

        return root;
    }

    static Node getSuccessor(Node root) {
        Node curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.key);
            inorderTraversal(root.right);
        }
    }
}
