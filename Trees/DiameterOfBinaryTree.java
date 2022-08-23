package Trees;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        myTree root=new myTree(10);
        root.left=new myTree(20);
        root.right=new myTree(30);
        root.right.left=new myTree(40);
        root.right.right=new myTree(60);
        root.right.left.left=new myTree(50);
        root.right.right.right=new myTree(70);


        System.out.println(dia(root));
        System.out.println(printDiaOptimized(root));
        System.out.println(res);
    }

        static int dia(myTree root) {
            if (root == null) return 0;
            int d1 = 1 + height(root.left) + height(root.right);
            int d2 = dia(root.left);
            int d3 = dia(root.right);

            return Math.max(d1, Math.max(d2, d3));
        }

        static int height(myTree root) {
            if (root == null) return 0;
            return 1 + Math.max(height(root.left), height(root.right));
        }

    static int res = 0;

    static int printDiaOptimized(myTree root) {
        if (root==null) return 0;
        int lh = printDiaOptimized(root.left);
        int rh = printDiaOptimized(root.right);
        res = Math.max(res,( 1 + lh + rh));

        return 1 + Math.max(lh, rh);
    }
}
