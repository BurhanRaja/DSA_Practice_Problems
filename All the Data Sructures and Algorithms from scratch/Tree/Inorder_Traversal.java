public class Inorder_Traversal {

    static class MyTree {
        int key;
        MyTree left;
        MyTree right;

        MyTree (int k) {
            this.key = k;
        }
    }

    public static void main(String[] args) {
        MyTree root = new MyTree(20);
        root.left = new MyTree(10);
        root.left.right = new MyTree(30);
        root.left.left = new MyTree(5);

        root.right = new MyTree(30);
        root.right.right = new MyTree(40);
        root.right.left = new MyTree(25);

        inorderTraversal(root);
    }

    // Left Root Right
    static void inorderTraversal(MyTree root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.key + " ");
            inorderTraversal(root.right);
        }
        
    }
}