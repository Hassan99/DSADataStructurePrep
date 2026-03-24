package ds.lineards.hashmapds.hashmap;

import java.util.Arrays;

public class LinearProbing {
    @Override
    public String toString() {
        return Arrays.toString(entries);
    }

    Entry[] entries;

    public LinearProbing() {
        entries = new Entry[5];
    }

    class Entry {
        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        int key;

        @Override
        public String toString() {
            return "(key=" + key + ", value='" + value + "')";
        }

        String value;

    }

    int count = 0;

    public void put(int key, String value) {
        isAdded = false;
        int index = hash(key);
        if (entries[index] == null) {
            entries[index] = new Entry(key, value);
            count++;
            return;
        }
        if (entries[index] != null && entries[index].key == key) {
            entries[index].value = value;
            return;
        }
        for (int i = 0; i < entries.length; i++) {
            index = linearProbeHash(index);
            if (entries[index] == null) {
                entries[index] = new Entry(key, value);
                count++;
                return;
            }

            if (entries[index].key == key) {
                entries[index].value = value;
                return;
            }
        }
        if (!isAdded && isFull()) {
            System.out.println("Resizing the Entries...");
            resize();
            put(key, value);
        }
    }

    boolean isAdded = false;

    public String get(int key) {
        int index = hash(key);

        for (int i = 0; i < entries.length; i++) {

            if (entries[index] == null)
                return null;

            if (entries[index].key == key)
                return entries[index].value;

            index = linearProbeHash(index);
        }
        return null;
    }

    public boolean remove(int key) {
        int index = hash(key);

        for (int i = 0; i < entries.length; i++) {

            if (entries[index] == null)
                return false;

            if (entries[index].key == key) {
                entries[index] = null;
                return true;
            }

            index = linearProbeHash(index);
        }
        return false;
    }

    void checkAndAdd(int index, int key, String value) {
        if (entries[index] == null) {
            entries[index] = new Entry(key, value);
            isAdded = true;
            count++;
        }
    }

    public void print() {
        System.out.println(this);
    }

    boolean isFull() {
        System.out.println("Count is:" + count);
        return count == entries.length;
    }

    void resize() {
       /* Entry[] entriesArray = new Entry[entries.length * 2];
        int index = 0;
        for (Entry entry : entries) {
            entriesArray[index] = new Entry(entry.key, entry.value);
            index++;
        }
        entries = entriesArray;*/

        Entry[] old = entries;
        entries = new Entry[old.length * 2];
        count = 0;

        for (Entry entry : old) {
            if (entry != null)
                put(entry.key, entry.value);
        }
    }


    private int hash(int key) {
        int length = entries.length;
        int index = key % length;
        return index;
    }

    private int linearProbeHash(int index) {
        return (index + 1) % entries.length;
    }
}
