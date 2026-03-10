package ds.queueds.linkedlistqueue;

public class LinkedListQueue {
    Node first;
    Node last;

    public class Node {
        int value;
        Node next;


        public Node(int value) {
            this.value = value;
        }
    }

    //    [10]
//
    public void enqueue(int item) {
        var node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int poppedValue = first.value;
        first = first.next;

        return poppedValue;
    }

    public void print() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        Node current = first;
        StringBuffer sb = new StringBuffer();
        while (current != null) {
            sb.append(current.value).append("->");
            current = current.next;
        }
        String value = sb.toString();
        int substring = value.lastIndexOf("->");
        String modified = value.substring(0,substring);
        System.out.println(modified);
    }

    private boolean isEmpty() {
        return first == null;
    }


}
