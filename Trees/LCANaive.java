package Trees;

import java.util.ArrayList;

public class LCANaive {
    public static void main(String[] args) {
        myTree root=new myTree(10);
        root.left=new myTree(20);
        root.right=new myTree(30);
        root.right.left=new myTree(40);
        root.right.right=new myTree(50);
        int n1=20,n2=50;

        myTree ans = lcaNaive(root, n1, n2);
        System.out.println(ans.data);
    }

    static myTree lcaNaive(myTree root, int n1, int n2) {
        ArrayList<myTree> p1 = new ArrayList<>();
        ArrayList<myTree> p2 = new ArrayList<>();

        if (!fp(root, p1, n1) || !fp(root, p2, n2)) return null;

        for (int i=0; i<p1.size()-1 && i<p2.size()-1; i++) {
            if (p1.get(i+1) != p2.get(i+1)) {
                return p1.get(i);
            }
        }

        return null;
    }

    static boolean fp(myTree root, ArrayList<myTree> list, int n) {
        if (root == null) return false;
        list.add(root);

        if (root.data == n) return true;

        if (fp(root.left, list, n) || fp(root.right, list, n)) return true;

        list.remove(list.size()-1);
        return false;
    }
}
