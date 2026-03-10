package ds.queueds.arrayqueue;

public class Main {
    public static void main(String[] args) {
        ArrayQueue aq=new ArrayQueue(5);
        aq.enque(10);
        aq.enque(20);
        aq.enque(30);
        aq.enque(40);
        aq.enque(50);

        System.out.println();

        aq.deque();
        aq.deque();
        aq.deque();

        System.out.println();
        aq.enque(60);
        aq.enque(70);

        System.out.println();
        aq.deque();
        aq.enque(80);
        aq.enque(90);
        System.out.println();
        aq.deque();
        aq.deque();
        System.out.println();
        aq.deque();
        aq.enque(100);
        aq.enque(110);
        aq.deque();
        System.out.println(aq.peek());

    }
}
