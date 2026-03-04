package arrayds;

public class Main {
    public static void main(String[] args) {
        ArrayClass ac = new ArrayClass(6);
        System.out.println("Inserting following Integers");
        ac.insert(-10);
        ac.insert(-20);
        ac.insert(-90);
        ac.insert(-30);
        ac.insert(-40);
        ac.insert(-50);
        ac.print();

        System.out.println("remove the integer at 4 , After Removed,");
//        ac.removeAt(4);
        System.out.println();
        System.out.println();
        ac.print();


        System.out.println("Index of 3 an Item is:" + ac.indexOf(30));

        System.out.println("Maximum Number from this array is: " + ac.max());

        ArrayClass ac1 = new ArrayClass(2);
        ac1.insert(20);
        ac1.insert(30);
        System.out.println("Intersect of an Array:");
        ac.intersect(ac1).print();

        System.out.println();
        System.out.println();
        ac.reverse().print();
        System.out.println();
        System.out.println("Inserted At 3:");
        ac.insertAt(44,0);
        ac.print();
    }


}