package ds.queueds.linkedlistqueue;

public class Main {
    public static void main(String[] args) {
        LinkedListQueue llq = new LinkedListQueue();
        llq.enqueue(10);
        llq.enqueue(20);
        llq.enqueue(30);
        llq.enqueue(40);
        llq.enqueue(50);
        llq.print();

        llq.dequeue();
        llq.print();

        llq.dequeue();
        llq.print();

        llq.dequeue();
        llq.print();

        llq.dequeue();
        llq.print();

        llq.dequeue();
        llq.print();


    }
}
