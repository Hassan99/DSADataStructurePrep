package linkedlisttest;

public class Main {
    public static void main(String[] args) {
        LinkedList lls = new LinkedList();
        lls.insert(10);
        lls.insert(20);
        lls.insert(30);
        lls.insert(40);
        lls.insert(50);
        lls.insert(60);
//        lls.insert(70);
        lls.print();
        System.out.println();

        System.out.println("Kth Node from List");
        System.out.println(lls.getKthNodeFromList(1));
        lls.printMiddle();


    }
}
