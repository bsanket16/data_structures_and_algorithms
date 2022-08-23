package Trees;

public class HeightOfBinaryTree {
    public static void main(String[] args)
    {
        myTree root=new myTree(10);
        root.left=new myTree(20);
        root.right=new myTree(30);
        root.right.left=new myTree(40);
        root.right.right=new myTree(50);

        System.out.println(height(root));
    }

    static int height(myTree root) {
        if (root == null) return 0;
        else return Math.max(height(root.left), height(root.right)) + 1;
    }
}
