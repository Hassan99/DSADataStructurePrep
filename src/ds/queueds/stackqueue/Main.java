package ds.queueds.stackqueue;

public class Main {
    public static void main(String[] args) {
        StackQueue sq = new StackQueue();
        sq.enque(10);
        sq.enque(20);
        sq.enque(30);
        sq.enque(40);
        sq.deque();
        sq.enque(50);
        sq.deque();
        sq.enque(60);
        sq.enque(70);
        sq.deque();
        sq.deque();
        sq.deque();
        sq.deque();

    }
}
