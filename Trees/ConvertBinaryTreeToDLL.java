package Trees;

public class ConvertBinaryTreeToDLL {
    static myTree prev = null;

    public static void main(String[] args) {
        myTree root=new myTree(10);
        root.left=new myTree(20);
        root.right=new myTree(30);

        root.left.left=new myTree(8);
        root.left.right=new myTree(7);
        root.right.left = new myTree(6);

        root.left.right.left=new myTree(9);
        root.left.right.right=new myTree(15);

        myTree head = BTTtoDLL(root);
        printList(head);
    }

    static myTree BTTtoDLL(myTree root) {
        if (root == null) return root;

        myTree head = BTTtoDLL(root.left);

        if (prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        BTTtoDLL(root.right);
        return head;
    }

    public static void printList(myTree head){
        myTree curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.right;
        }
    }
}
