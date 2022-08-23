package LinkedList;

class Nodes
{
    int data;
    Nodes next;
    Nodes bottom;

    Nodes(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}

public class FlattenALinkedList {

    Nodes flatten(Nodes root)
    {
        if (root == null || root.next == null) return root;

        Nodes curr = root;

        while (curr.next != null) {

            Nodes next = curr.next.next;
            Nodes newHead = merge(curr, curr.next);
            System.out.print(newHead.data);
            newHead.next = next;
            curr = newHead;
        }

        return curr;
    }

    Nodes merge(Nodes first, Nodes second) {

        Nodes curr = new Nodes(0);
        Nodes temp = curr;

        while (first != null && second != null) {

            if (first.data <= second.data) {
                temp.bottom = new Nodes(first.data);
                temp = temp.bottom;
                first = first.bottom;
            }
            else {
                temp.bottom = new Nodes(second.data);
                temp = temp.bottom;
                second = second.bottom;
            }
        }

        while (first != null) {

            temp.bottom = new Nodes(first.data);
            temp = temp.bottom;
            first = first.bottom;
        }

        while (second != null) {

            temp.bottom = new Nodes(second.data);
            temp = temp.bottom;
            second = second.bottom;
        }

        return curr.bottom;
    }

    public static void main(String[] args) {

        Nodes head = new Nodes(5);
        head.bottom = new Nodes(7);
        head.bottom.bottom = new Nodes(8);
        head.bottom.bottom.bottom = new Nodes(30);

        head.next = new Nodes(10);
        head.next.bottom = new Nodes(20);

        head.next.next = new Nodes(19);
        head.next.next.bottom = new Nodes(22);
        head.next.next.bottom.bottom = new Nodes(50);

        head.next.next.next = new Nodes(28);
        head.next.next.next.bottom = new Nodes(35);
        head.next.next.next.bottom.bottom = new Nodes(40);
        head.next.next.next.bottom.bottom.bottom = new Nodes(45);

        FlattenALinkedList obj = new FlattenALinkedList();

        printLinkedList(obj.flatten(head));
    }

    static void printLinkedList(Nodes head) {
        Nodes curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.bottom;
        }
    }
}