package BST;

public class FloorAndCeil {
    public static void main(String[] args) {
        BST root = new BST(15);
        root.left = new BST(5);
        root.right = new BST(20);

        root.left.left = new BST(3);

        root.right.left = new BST(18);
        root.right.right = new BST(80);

        root.right.left.left = new BST(16);

        int key = 28;

        getFloor(root, key);
        getCeil(root, key);
    }

    static void getFloor(BST root, int key) {
        int floor = -1;
        BST curr = root;

        while (curr != null) {
            if (curr.data > key){
                curr = curr.left;
            }
            else if (curr.data < key) {
                floor = curr.data;
                curr = curr.right;
            }
            else {
                System.out.println(curr.data);
                return;
            }
        }

        System.out.println("floor: " + floor);
    }

    static void getCeil(BST root, int key) {
        int ceil = -1;
        BST curr = root;

        while (curr != null) {
            if (curr.data < key){
                curr = curr.right;
            }
            else if (curr.data > key) {
                ceil = curr.data;
                curr = curr.left;
            }
            else {
                System.out.println(curr.data);
                return;
            }
        }

        System.out.println("ceil: " + ceil);
    }
}
