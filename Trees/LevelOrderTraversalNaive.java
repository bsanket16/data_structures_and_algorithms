package Trees;

public class LevelOrderTraversalNaive {
    public static void main(String[] args)
    {
        myTree root=new myTree(10);
        root.left=new myTree(20);
        root.right=new myTree(30);

        root.left.left=new myTree(8);
        root.left.right=new myTree(7);
        root.right.left = new myTree(6);

        root.left.right.left=new myTree(9);
        root.left.right.right=new myTree(15);

        int h = height(root);
        for (int i=0; i<h; i++) {
            PrintNodes(root, i);
        }
    }

    static void PrintNodes(myTree root, int k) {
        if (root == null) return;
        if (k == 0) System.out.print(root.data + " ");
        else {
            PrintNodes(root.left, k-1);
            PrintNodes(root.right, k-1);
        }
    }

    static int height(myTree root) {
        if (root == null) return 0;
        else return Math.max(height(root.left), height(root.right)) + 1;
    }
}
