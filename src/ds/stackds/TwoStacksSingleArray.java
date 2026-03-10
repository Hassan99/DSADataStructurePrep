package ds.stackds;

public class TwoStacksSingleArray {
    int totalSize;
    int[] array;
    int top1;
    int top2;

    public TwoStacksSingleArray(int size) {
        totalSize = size;
        array = new int[size];
        top1 = -1;
        top2 = size - 1;
    }

    public void push1(int item) {
        if (top1 + 1 == top2) {
            System.out.println("Stack is Full");
            return;
        }
        array[top1++] = item;
    }

    public void push2(int item) {
        if (top1 + 1 == top2) {
            System.out.println("Stack is Full");
            return;
        }
        array[--top2] = item;
    }
    public int pop1(){
        if(top1 ==-1){
            System.out.println("stack is empty");
            return -1;
        }
        return array[--top1];
    }
    public int pop2(){
        if(top2 == totalSize-1){
            System.out.println("stack is empty");
            return -1;
        }
        return array[++top2];
    }
}
