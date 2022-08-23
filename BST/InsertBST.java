package BST;

public class InsertBST {
    public static void main(String[] args) {
        BST root = new BST(15);
        root.left = new BST(5);
        root.right = new BST(20);

        root.left.left = new BST(3);

        root.right.left = new BST(18);
        root.right.right = new BST(80);

        root.right.left.left = new BST(16);

        int key = 25;

        BST newRoot = insertIterative(root, key);
        inorder(newRoot);
    }

    static void inorder(BST root) {
        if (root == null) return;
        System.out.print(root.data + " ");

        inorder(root.left);
        inorder(root.right);
    }

    static BST insert(BST root, int key) {
        if (root == null) {
            return new BST(key);
        }

        if (root.data > key){
            root.left = insert(root.left, key);
        }
        else if (root.data < key){
            root.right = insert(root.right, key);
        }
        return root;
    }

    static BST insertIterative (BST root, int key) {
        BST temp = new BST(key);

        BST parent = null;
        BST curr = root;

        while (curr != null) {
            parent = curr;

            if (curr.data > key) {
                curr = curr.left;
            }

            else if (curr.data < key) {
                curr = curr.right;
            }

            else return root;
        }

        if (parent == null) return temp;

        if (parent.data < key){
            parent.right = temp;
        } else {
            parent.left = temp;
        }

        return root;
    }
}
