package Trees;

public class CheckForBalancedTree {
    public static void main(String[] args) {
        myTree root=new myTree(18);
        root.left=new myTree(4);
        root.right=new myTree(20);
        root.right.left = new myTree(13);
        root.right.right = new myTree(70);

        System.out.println(cfbtNaive(root) ? "true"  : "false");
        System.out.println(cfbt(root) >= 0 ? "true"  : "false");
    }

    static boolean cfbtNaive(myTree root) {
        if (root == null) return true;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.abs(lh-rh) <= 1 && cfbtNaive(root.left) && cfbtNaive(root.right);
    }

    static int height(myTree root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int cfbt(myTree root) {
        if (root == null) return 0;

        int lh = cfbt(root.left);
        if (lh == -1) return -1;

        int rh = cfbt(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh-rh) > 1) return -1;
        else return 1 + Math.max(lh, rh);
    }
}
