package Trees;

import java.util.ArrayDeque;

public class MaximumInBinaryTree {
    public static void main(String[] args) {
        myTree root=new myTree(10);
        root.left=new myTree(20);
        root.right=new myTree(30);

        root.left.left=new myTree(8);
        root.left.right=new myTree(7);
        root.right.left = new myTree(6);

        root.left.right.left=new myTree(9);
        root.left.right.right=new myTree(15);

        System.out.println(maxRecursive(root));
        System.out.println(maxIterative(root));
    }

    static int maxIterative(myTree root) {
        if (root == null) return Integer.MIN_VALUE;
        ArrayDeque<myTree> q = new ArrayDeque<>();
        int res = 0;
        q.add(root);

        while(!q.isEmpty()) {
            myTree curr = q.poll();
            res = Math.max(curr.data, res);

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }

        return res;
    }

    static int maxRecursive(myTree root) {
        if (root == null) return Integer.MIN_VALUE;
        else return Math.max(root.data , Math.max(maxRecursive(root.left), maxRecursive(root.right)));
    }


}
