package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {
    public static void main(String[] args) {
        myTree root=new myTree(10);
        root.left=new myTree(20);
        root.right=new myTree(30);

        root.left.left=new myTree(8);
        root.left.right=new myTree(7);
        root.right.left = new myTree(6);

        root.left.right.left=new myTree(9);
        root.left.right.right=new myTree(15);

//        levelOrderTraversalLineByLineNaive(root);
        levelOrderTraversalLineByLine(root);
    }

    static void levelOrderTraversalLineByLineNaive(myTree root) {
        if(root==null) return;
        Queue<myTree> q=new LinkedList<>();
        q.offer(root);
        q.add(null);

        while (q.size() > 1) {
            myTree curr = q.poll();
            if (curr == null) {
                System.out.println();
                q.add(null);
                continue;
            }
            System.out.print(curr.data + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    static void levelOrderTraversalLineByLine(myTree root) {
        if(root==null) return;
        Queue<myTree> q=new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int cnt = q.size();
            for (int i=0; i<cnt; i++) {
                myTree curr = q.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            System.out.println();
        }
    }
}
