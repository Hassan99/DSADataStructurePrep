package ds.lineards.hashmapds.hashtable;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.put(1);
        hashTable.put(2);
        hashTable.put(2);
        hashTable.put(3);
        hashTable.put(3);
        hashTable.put(3);
        hashTable.put(4);
        hashTable.put(5);
        hashTable.put(5);
        hashTable.put(5);
        hashTable.put(5);
        hashTable.put(4);
        hashTable.put(6);
        System.out.println(hashTable.mostRepeatedElement());
    }
}
