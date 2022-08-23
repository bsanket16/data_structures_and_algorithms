package Trees;

public class PostorderTraversal {
    public static void main(String[] args)
    {
        myTree root=new myTree(10);
        root.left=new myTree(20);
        root.right=new myTree(30);
        root.right.left=new myTree(40);
        root.right.right=new myTree(50);

        postorder(root);
    }

    static void postorder(myTree root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
