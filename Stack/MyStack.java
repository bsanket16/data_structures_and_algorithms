package Stack;

class MyStack {
    int[] arr;
    int top;
    int cap;

    MyStack(int c) {
        cap = c;
        top = -1;
        arr = new int[c];
    }

    void push(int x) {
        if (top+1 == cap) {
            System.out.println("stack full");
            return;
        }
        top++;
        arr[top] = x;
        System.out.println("pushed " + x);
    }

    void pop() {
        if (top == -1) {
            System.out.println("nothing to pop");
            return;
        }
        System.out.println("popped " + arr[top]);
        top--;
    }

    int size() {
        return top+1;
    }

    boolean isEmpty() {
        return (top==-1);
    }

    void peek() {
        if (top == -1) {
            System.out.println("stack empty");
            return;
        }
        System.out.println("peek " + arr[top]);
    }

}
class Stack {
    public static void main(String[] args) {
        MyStack s = new MyStack(5);

        s.peek();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(35);
        s.peek();
        s.pop();
        s.push(40);
        s.push(50);
        s.push(60);
        System.out.println("size " + s.size());
        System.out.println(s.isEmpty());
    }
}
