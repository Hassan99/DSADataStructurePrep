package ds.stackds.stackwithqueue;

public class Main {
    public static void main(String[] args) {
        StackWithQueue stack = new StackWithQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
    }
}
