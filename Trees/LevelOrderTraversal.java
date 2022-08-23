package Trees;

import java.util.ArrayDeque;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        myTree root=new myTree(10);
        root.left=new myTree(20);
        root.right=new myTree(30);

        root.left.left=new myTree(8);
        root.left.right=new myTree(7);
        root.right.left = new myTree(6);

        root.left.right.left=new myTree(9);
        root.left.right.right=new myTree(15);

        printLevelOrder(root);
    }

    static void printLevelOrder(myTree root) {
        if(root == null) return;

        ArrayDeque<myTree> q = new ArrayDeque<>();
        q.push(root);

        while (!q.isEmpty()) {
            myTree curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
    }
}
