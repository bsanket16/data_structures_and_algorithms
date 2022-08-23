package Trees;

import java.util.ArrayDeque;

public class PrintLeftView {
    static int maxLevel = 0;

    public static void main(String[] args) {
        myTree root=new myTree(10);
        root.left=new myTree(20);
        root.right=new myTree(30);

        root.left.left=new myTree(8);
        root.left.right=new myTree(7);
        root.right.left = new myTree(6);

        root.left.right.left=new myTree(9);
        root.left.right.right=new myTree(15);

        printLeftViewIterative(root);
        printLeftViewRecursive(root, 1);
    }

    static void printLeftViewRecursive(myTree root, int level) {
        if (root == null) return;

        if (maxLevel < level) {
            System.out.print(root.data + " ");
            maxLevel = level;
        }

        printLeftViewRecursive(root.left,level+1);
        printLeftViewRecursive(root.right,level+1);
    }

    static void printLeftViewIterative(myTree root) {
        if (root == null) return;
        ArrayDeque<myTree> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int cnt = q.size();

            for (int i=0; i<cnt; i++) {
                myTree curr = q.poll();

                if (i==0) {
                    System.out.print(curr.data + " ");
                }

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
    }
}
