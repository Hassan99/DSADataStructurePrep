package ds.queueds.stackqueue;

import ds.stackds.StackDS;

import java.util.Stack;

public class StackQueue {
    private final Stack<Integer> stackDS1 = new Stack<>();
    private final Stack<Integer> stackDS2 = new Stack<>();
    public void enque(int item){
        stackDS1.push(item);
        System.out.println(stackDS1);
        System.out.println();
    }
    public void deque(){
        if(stackDS1.isEmpty() && stackDS2.isEmpty()){
            throw new IllegalStateException();
        }
        System.out.println("Dequeue in progress");
        if(stackDS2.isEmpty()) {
            moveStack1ToStake2();
        }
        stackDS2.pop();
        moveStack2ToStake1();
        System.out.println(stackDS1);
        System.out.println();
    }

    private void moveStack1ToStake2(){
        while(!stackDS1.isEmpty()){
            stackDS2.push(stackDS1.pop());
        }
    }
    private void moveStack2ToStake1(){
        while(!stackDS2.isEmpty()){
            stackDS1.push(stackDS2.pop());
        }
    }
}
