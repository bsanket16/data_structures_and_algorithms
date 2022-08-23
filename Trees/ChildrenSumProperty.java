package Trees;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        myTree root=new myTree(10);
        root.left=new myTree(20);
        root.right=new myTree(30);

        root.left.left=new myTree(8);
        root.left.right=new myTree(7);
        root.right.left = new myTree(6);

        root.left.right.left=new myTree(9);
        root.left.right.right=new myTree(15);

        System.out.println(csProperty(root));
    }

    static boolean csProperty(myTree root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        int sum = 0;
        if (root.left != null) sum += root.left.data;
        if (root.right != null) sum += root.right.data;

        return root.data == sum && csProperty(root.left) && csProperty(root.right);
    }
}
