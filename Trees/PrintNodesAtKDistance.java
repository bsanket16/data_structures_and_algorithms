package Trees;

public class PrintNodesAtKDistance {
    public static void main(String[] args)
    {
        myTree root=new myTree(10);
        root.left=new myTree(20);
        root.right=new myTree(30);
        root.right.left=new myTree(40);
        root.right.right=new myTree(50);

        int k = 2;
        print(root , k);
    }

    static void print(myTree root, int k) {
        if (root == null) return;
        if (k == 0) System.out.print(root.data + " ");
        else {
            print(root.left, k-1);
            print(root.right, k-1);
        }
    }
}
