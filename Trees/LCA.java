package Trees;

public class LCA {
    public static void main(String[] args) {
        myTree root=new myTree(10);
        root.left=new myTree(20);
        root.right=new myTree(30);
        root.right.left=new myTree(40);
        root.right.right=new myTree(60);
        root.right.left.left=new myTree(50);
        root.right.right.right=new myTree(70);

        myTree ans = lca(root, 30, 70);
        System.out.println(ans.data);
    }

    static myTree lca(myTree root, int n1, int n2) {
        if (root == null) return null;

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        myTree lca1 = lca(root.left, n1, n2);
        myTree lca2 = lca(root.right, n1, n2);

        if (lca1 != null && lca2 != null) {
            return root;
        }

        if (lca1!=null) return lca1;
        else return lca2;
    }
}
