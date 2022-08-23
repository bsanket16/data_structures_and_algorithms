package Trees;

import java.util.ArrayDeque;

public class SizeOfBinaryTree {
    public static void main(String[] args) {
        myTree root=new myTree(10);
        root.left=new myTree(20);
        root.right=new myTree(30);

        root.left.left=new myTree(8);
        root.left.right=new myTree(7);
        root.right.left = new myTree(6);

        root.left.right.left=new myTree(9);
        root.left.right.right=new myTree(15);

        System.out.println(sizeRecursive(root));
        System.out.println(sizeIterative(root));
    }

    static int sizeIterative(myTree root) {
        if (root == null) return 0;
        ArrayDeque<myTree> q = new ArrayDeque<>();
        int cnt = 0;
        q.add(root);

        while(!q.isEmpty()) {
            myTree curr = q.poll();
            cnt++;

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }

        return cnt;
    }

    static int sizeRecursive(myTree root) {
        if (root == null) return 0;
        else return 1 + (sizeRecursive(root.left) + sizeRecursive(root.right));
    }


}
