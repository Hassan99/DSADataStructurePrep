package linkedlisttest;

public class LinkedList {
    Node first;
    Node last;

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    public void addFirst(int value) {
        //  [ 10  20 ]
        //    L -> C
        Node firstNode = new Node(value);
        if (first == null) {
            first = firstNode;
            last = firstNode;
        } else {
            firstNode.next = first;
            first = firstNode;
        }
    }
    public void insert(int value){

        Node node = new Node(value);
        if(isEmpty()){
            first = last = node;
            return;
        }
        last.next = node;
        last = node;
    }

    public void addLast(int value) {
        //  [ 10  20 ]
        //    L -> C
        Node node = new Node(value);
        if (first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        if (first.next == null) {
            first = null;
            last = null;
            return;
        }
        Node newNode = first.next;
        first.next = null;
        first = newNode;
    }

    public void deleteLast() {
        //  [ 10  20 ]
        //     P   C
        if (isEmpty()) {
            return;
        }
        if (first.next == null) {
            first = null;
            last = null;
            return;
        }

        Node previous = first;
        Node current = first.next;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        last = previous;
        last.next = null;
    }

    public int indexOf(int value) {
        if (isEmpty()) {
            return -1;
        }
        Node current = first;
        int index = 0;
        boolean isFound = false;
        while (current != null) {
            if (current.value == value) {
                isFound = true;
                break;
            }
            current = current.next;
            index++;
        }
        return isFound ? index : -1;
    }

    public boolean isEmpty(){
        if (first == null) {
            System.out.println("No Items in the list");
            return true;
        }
        return false;
    }
    public void reverse() {
        //  [ 10->20->30->40 ]
        //                 P   C
        //  [40->30->20->10]
        if (isEmpty()) {
            return;
        }
        Node previous = first;
        Node current = first.next;
         while (current!=null){
             Node next = current.next;
             current.next = previous;
             previous = current;
             current = next;
         }


         last = first;
         last.next = null;

         first = previous;


    }
    public int getKthNodeFromList(int k){
        if(isEmpty()){
            return -1;
        }
        Node a = first;
        Node b = first;
        //[10,20,30,40,50,60,70,80,90,100]
        // ||
        //K = 4
        //                    ^            ^

        for(int i = 0;i<k;i++){
            b = b.next;
            if(b==null){
                throw new IllegalArgumentException();
            }
        }
        while (b!=null){
            a=a.next;
            b=b.next;
            if(b==null){
               return a.value;
            }
        }
        return -1;
    }
    public void printMiddle(){
        Node a = first;
        Node b = first;
        while(b!=last && b.next!=last){
            a=a.next;
            b=b.next.next;
        }
        if(b==last){
            System.out.println("Middle: " + a.value );
        }else{
            System.out.println("Middle: " + a.value + ", " + a.next.value);
        }
    }

    public void print(){
        if(isEmpty()){
            return;
        }
        Node current = first;
        while (current!=null){
            System.out.println(current.value);
            current = current.next;
        }
    }
}
