package ds.queueds.queuetest;

public class Main {
    public static void main(String[] args) {
        QueueReverse qr = new QueueReverse(5);
        qr.enqueue(10);
        qr.enqueue(20);
        qr.enqueue(30);
        qr.enqueue(40);
        qr.enqueue(50);
        qr.itemToReverseFromKthPos(3);

    }
}
