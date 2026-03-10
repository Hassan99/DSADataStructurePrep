package ds.stackds;

import java.util.Arrays;

public class StackDS {
    int[] array;
    int index = 0;

    public StackDS() {
        array = new int[10];
    }

    public void push(int obj) {
        if (index == array.length) {
            System.out.println("Stack is full");
            return;
        }

        array[index++] = obj;

    }

    public int pop() {
        if (index == 0) {
            System.out.println("No More elements to remove from the stack");
            return -1;
        }
        return array[--index];
    }

    public int peek() {
        if (index == 0) {
            System.out.println("No More elements in the stack");
            return -1;
        }
        return array[index - 1];
    }

    public boolean isEmpty() {
        return array.length == 0;
    }

    public boolean isFull() {
        return index == array.length;
    }

    public void print() {
        for (int i = index - 1; i > 0; i--) {
            System.out.println(array[i]);
        }
    }

    public int size() {
        return index;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
