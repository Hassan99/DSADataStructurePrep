package ds.stackds.stackwithqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithQueue {
    Queue<Integer> firstQueue = new ArrayDeque<>();
    Queue<Integer> secondQueue = new ArrayDeque<>();

    public void push(int item) {
        firstQueue.add(item);
    }

    public void pop() {
        if (firstQueue.isEmpty()) {
            throw new IllegalStateException();
        }
        while (!firstQueue.isEmpty()) {
            int removableValue = firstQueue.remove();
            if (firstQueue.isEmpty()) {

            } else {
                secondQueue.add(removableValue);
            }
        }
        while (!secondQueue.isEmpty()) {
            firstQueue.add(secondQueue.remove());
        }
    }

    public void print() {
        System.out.println(firstQueue.toString());
    }
}
