package Trees;

import java.util.*;

public class TreeTraversalSpiralForm {
    public static void main(String[] args) {
        myTree root = new myTree(1);
        root.left = new myTree(2);
        root.right = new myTree(3);
        root.left.left = new myTree(4);
        root.left.right = new myTree(5);
        root.right.left = new myTree(6);
        root.right.right = new myTree(7);
        root.left.left.left = new myTree(8);
        root.left.left.right = new myTree(9);
        root.right.left.left = new myTree(10);

        printSpiral(root);
        System.out.println();
        printSpiralOptimized(root);
    }

    static void printSpiral(myTree root) {
        if (root == null) return;
        Queue<myTree> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        q.add(root);
        boolean rev = false;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i=0; i<sz; i++) {
                myTree curr = q.poll();
                if (rev) {
                    s.push(curr.data);
                } else {
                    System.out.print(curr.data + " ");
                }

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            if (rev) {
                while (!s.isEmpty()) {
                    System.out.print(s.pop() + " ");
                }
            }
            rev = !rev;
        }
    }

    static void printSpiralOptimized(myTree root) {
        if (root == null) return;
        Stack<myTree> s1 = new Stack<>();
        Stack<myTree> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                myTree curr = s1.pop();
                System.out.print(curr.data + " ");

                if (curr.left != null) s2.push(curr.left);
                if (curr.right != null) s2.push(curr.right);
            }

            while (!s2.isEmpty()) {
                myTree curr = s2.pop();
                System.out.print(curr.data + " ");

                if (curr.right != null) s1.push(curr.right);
                if (curr.left != null) s1.push(curr.left);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        ArrayList<Integer> a = new ArrayList<>();

        Collections.reverse(a);
    }
}
