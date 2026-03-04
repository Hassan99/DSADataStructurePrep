package linkedlistds;

import java.util.NoSuchElementException;

public class LinkedListClass {
    Node first;
    Node last;

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    private boolean isEmpty() {
        return first == null;
    }

    public void addFirst(int value) {
        var node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
    }

    public void addLast(int value) {
        var node = new Node(value);
        if (isEmpty()) {
            // here first and last node pointing to same memory object.
            // so Here, whatever changes we make in last node, the first
            // node will see the changes
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public int indexOf(int value) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int value) {
        Node current = first;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void addAt(int index, int value) {
        if (index < 0)
            throw new IllegalArgumentException();
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node current = first;
        int indx = 0;
        while (current != null && indx < index - 1) {
            current = current.next;
            indx++;
        }
        if (current == null) {
            throw new IllegalArgumentException();
        }
        var node = new Node(value);
        node.next = current.next;
        current.next = node;

        if (node.next == null) {
            last = node;
        }

    }


    public void removeAt(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            first = first.next;
            if (first == null)
                last = null;
            return;
        }
        Node current = first;
        int currentIndex = 0;
        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }
        if (current.next == last) {
            last = current;
        }
        current.next = current.next.next;
    }

    public void removeFirst(){
        if(first==null){
            throw new NoSuchElementException();
        }
        if(first==last){
            first=last=null;
        }
        first = first.next;

    }
    public void removeLast(){
        if(first==null){
            throw new NoSuchElementException();
        }
        if(first == last){
            first =last=null;
        }

        Node node= first;
        while (node.next!=last){
            node = node.next;
        }
        node.next=null;
        last=node;
    }


    public void reverse(){
        // f            l
        //[10 -> 20 -> 30 -> 40]
        // P   C


        if(isEmpty()){
            System.out.println("No Items In this LinkedList");
            return;
        }

        Node previous = first;
        Node current = first.next;


        last = first;
        last.next = null;

        while (current!=null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        first = previous;


    }
    public void reverseLinkedListAsString(){
        // f            l
        //[10 -> 20 -> 30 -> 40]
        // P   C


        if(isEmpty()){
            System.out.println("No Items In this LinkedList");
            return;
        }

        Node previous = first;
        Node current = first.next;


        last = first;
        last.next = null;

        while (current!=null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        first = previous;


    }







    /*public void reverse(){
        // f            l
        //[10 <- 20 -> 30 -> 40]
        // P   C
        if(isEmpty()){
            return;
        }
        Node previous = first;
        Node current = first.next;

        last = first;
        last.next = null;
        while (current!=null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        first = previous;
    }*/
    public int getFindKthNodeFromEnd(int k){ //One Pass method - Two Pointers
        Node first = this.first;
        Node second = this.first;

        if(isEmpty()){
            throw new IllegalArgumentException();
        }

        for(int i=0;i<k;i++){
            if(second==null){
                throw new IllegalArgumentException();
            }
            second = second.next;
        }
        while (second!=null){
            first = first.next;
            second = second.next;
        }
        return first.value;
    }
    public int printMiddle(){
        Node first = this.first;
        Node second = this.first;
        while (second!=last && second.next!=last){
            second = second.next.next;
            first = first.next;
        }
        if(second ==last){
            return first.value;
        }else{
            return first.value;
        }
    }


    public void print() {
        Node node = first;
        while (node != null) {
            System.out.print(node.value+"\t");
            node = node.next;
        }
    }
    public String getAsString() {
        Node node = first;
        StringBuffer sb= new StringBuffer();
        while (node != null) {
            sb.append(String.valueOf(node.value));

            node = node.next;
        }
        return sb.toString();
    }
    //addFirst
    //addLast
    //indexOf
    //deleteFirst
    //deleteLast
    //contains
    //addMiddle
    //removeMiddle


}
