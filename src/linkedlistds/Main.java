package linkedlistds;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LinkedListClass lls = new LinkedListClass();
        lls.addLast(10);
        lls.addLast(20);
        lls.addLast(30);
        lls.addLast(40);
        lls.addLast(50);
        lls.addLast(60);
        lls.addLast(70);
        lls.addLast(80);
        lls.addLast(90);
        lls.addLast(100);
        lls.print();
        System.out.println();
        System.out.println();
        lls.addAt(1, 15);
        lls.print();
        System.out.println();
        System.out.println();
        lls.addAt(3, 25);
        lls.print();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        lls.removeAt(3);
//        lls.print();
//        System.out.println();
//        System.out.println();
//        lls.removeLast();
//        lls.print();
//        System.out.println();
//        System.out.println();
//        lls.removeLast();
//        lls.print();
        System.out.println();
        System.out.println("The Reversed List is:");
        lls.reverse();
        lls.print();
        System.out.println();
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the K th Node to find:");
        int value = scanner.nextInt();
        System.out.println(value + " Node value is: " + lls.getFindKthNodeFromEnd(value));
        System.out.println();
        System.out.println();
        System.out.println("Middle Node is"+lls.printMiddle());

        lls.getAsString();
    }
}
