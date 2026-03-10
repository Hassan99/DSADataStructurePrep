package ds.queueds.arrayqueue;

import java.util.Arrays;

public class ArrayQueue {
    int[] array;

    int rear;
    int front;
    int count;
    public ArrayQueue(int size) {
        this.array = new int[size];
    }
    public void enque(int item){

        array[rear] = item;
        rear = (rear+1)%array.length;
        System.out.println(this);
        count++;
    }
    public void deque(){

        array[front] = 0;
        front = (front+1)%array.length;
        System.out.println(this);
        count--;
    }
    public int peek(){
        if(count == 0){
            System.out.println("Queue is empty");
            return -1;
        }
        return array[front];
    }

    @Override
    public String toString(){
       return Arrays.toString(array);
    }
}
