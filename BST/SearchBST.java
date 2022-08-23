package BST;

public class SearchBST {
    public static void main(String[] args) {
        BST root = new BST(15);
        root.left = new BST(5);
        root.right = new BST(20);

        root.left.left = new BST(3);

        root.right.left = new BST(18);
        root.right.right = new BST(80);

        root.right.left.left = new BST(16);

        int key = 16;

        System.out.println(search(root, key));
        System.out.println(searchIterative(root, key));
    }

    static boolean search(BST root, int key) {
        if (root == null) return false;

        if (root.data == key) return true;

        if (root.data < key) return search(root.right, key);

        else return  search(root.left, key);
    }

    static boolean searchIterative (BST root, int key) {
        if (root == null) return false;

        while (root != null) {
            if (root.data == key) return true;

            if (root.data > key) root = root.left;
            else root = root.right;
        }

        return false;
    }
}
