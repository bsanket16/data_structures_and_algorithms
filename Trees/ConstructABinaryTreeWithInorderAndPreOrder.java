package Trees;

public class ConstructABinaryTreeWithInorderAndPreOrder {
    public static void main(String[] args) {
        int[] in={20,10,40,30,50};
        int[] pre={10,20,30,40,50};

        myTree root = cTree(in, pre, 0, in.length-1);
        inorder(root);
    }

    static int preIndex = 0;

    static myTree cTree(int[] in, int[] pre, int is, int ie) {
        if (is > ie) return null;

        myTree root = new myTree(pre[preIndex++]);

        int index = is;
        for (int i=is; i<=ie; i++){
            if (in[i] == root.data) {
                index = i;
            }
        }

        root.left = cTree(in, pre, is, index-1);
        root.right = cTree(in, pre, index+1, ie);

        return root;
    }

    static void inorder(myTree root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
