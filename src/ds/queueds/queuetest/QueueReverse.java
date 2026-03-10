package ds.queueds.queuetest;

import java.util.Arrays;
import java.util.Stack;

public class QueueReverse {
    private int[] array;
    private int count;

    int front = 0;
    int rear = 0;

    public QueueReverse(int size) {
        array = new int[size];
    }

    //    [10,20,30,40,50]
//                  C
    public void enqueue(int item) {
        if (count == array.length) {
            throw new IllegalArgumentException();
        }
        array[rear] = item;
        rear = (rear + 1) % array.length;
        count++;
        System.out.println(this);
    }

    public int dequeue() {
        if (count == 0) {
            throw new IllegalArgumentException();
        }
        int returnableValue = array[front];
        array[front] = 0;
        front = (front + 1) % array.length;
        count--;
        System.out.println(this);
        return returnableValue;
    }


    public void itemToReverseFromKthPos(int k) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < k) {
            stack.push(dequeue());
            i++;
        }

        while (!stack.isEmpty()) {
            enqueue(stack.pop());
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
