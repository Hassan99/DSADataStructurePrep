package ds.lineards.hashmapds.hashmap;

public class Main {
    public static void main(String[] args) {
        LinearProbing linearProbing = new LinearProbing();

        linearProbing.put(2, "A");
        linearProbing.put(4, "B");
        linearProbing.put(6, "D");
        linearProbing.put(7, "C");
        linearProbing.put(8, "E");
        linearProbing.put(9, "F");
        linearProbing.put(10, "G");
        linearProbing.put(12, "H");
        linearProbing.put(11, "I");
        linearProbing.put(13, "J");
        linearProbing.put(14, "K");
        linearProbing.print();
        System.out.println(linearProbing.get(13));
        System.out.println(linearProbing.remove(11));
        linearProbing.print();
    }
}
