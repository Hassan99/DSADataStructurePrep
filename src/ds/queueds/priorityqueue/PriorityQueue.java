package ds.queueds.priorityqueue;

import java.util.Arrays;

public class PriorityQueue {
    int[] array;
    int count = 0;
    int rear = 0;

    public PriorityQueue(int size) {
        array = new int[size];
    }

    /*

    // this is my own implementation after know the
    // logic of this priority queue. this is OK.
    // but it is not optimal solution.
    public void enqueue(int item) {
        if (count == array.length) {
            throw new IllegalArgumentException();
        }
        if (count == 0) {
            array[count++] = item;
            rear++;
            return;
        }
//        [2]
//        //1
//        [2,2,5,6]
//        [0,1,2,3]
//           R

        if (array[count-1] > item) {
            while (array[rear-1] > item) {
                int rearItem = array[rear-1];
                array[rear] = rearItem;
                if (rear > 1) {
                    rear = rear - 1;
                } else {
                    array[--rear] = item;
                }
                if(rear==0){
                    break;
                }
            }
            if(rear!=0){
                array[rear] = item;
            }
            rear = count  = count+1;
            System.out.println("executed");
        } else {
            array[count++] = item;
            rear++;
        }
        print();
    }*/
    // Priority Queue should be in Sorted order
    /*      [20, 0, 0, 0, 0, 0, 0, 0, 0, 0]   //First item added
            [15, 20, 0, 0, 0, 0, 0, 0, 0, 0]  //When second item added, first item is shifted to right and first item has replaced by the new item
            [1, 15, 20, 0, 0, 0, 0, 0, 0, 0]  //Same here.
            [1, 15, 18, 20, 0, 0, 0, 0, 0, 0] //this priority queue is sorted always.
            [1, 6, 15, 18, 20, 0, 0, 0, 0, 0]
            [1, 5, 6, 15, 18, 20, 0, 0, 0, 0]
            [1, 5, 6, 15, 16, 18, 20, 0, 0, 0]
            [1, 5, 6, 14, 15, 16, 18, 20, 0, 0]
            [1, 3, 5, 6, 14, 15, 16, 18, 20, 0]*/
    public void enqueue(int item) {
        if (count == array.length) {
            throw new IllegalArgumentException();
        }
        //we should move the item from last item of an array

        int index = count - 1; // taking the first index
        while (index >= 0 && array[index] > item) {
            array[index + 1] = array[index]; // shifting bigger value shifting to right of an array
            index--; //pointer moving to previous index to check, enqueued item and current item equality
                     // if pushed item is smaller than index item, then current item will be shifting to right.
        }
        array[index + 1] = item;
        count = count + 1;
        print();
    }

    void print() {
        System.out.println(Arrays.toString(array));
    }
}
