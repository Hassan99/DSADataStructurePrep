package ds.lineards.hashmapds.hashtable;

import java.util.LinkedList;

public class HashTable {
    LinkedList<Entry>[] linkedLists = new LinkedList[5];

    public static class Entry {

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        int key;
        String value;
    }

    public void put(int key, String value) {
        int index = hash(key);

        if (linkedLists[index] == null) {
            linkedLists[index] = new LinkedList<>();
        }
        LinkedList<Entry> existingItem = linkedLists[index];
        Entry entry = new Entry(key, value);
        if (!existingItem.isEmpty()) {
            for (Entry item : existingItem) {
                if (item.key == key) {
                    item.value = value;
                    return;
                }
            }
            existingItem.add(entry);
        } else {
            LinkedList<Entry> entryList = new LinkedList<>();
            entryList.add(entry);
            linkedLists[index] = entryList;
        }
    }

    public String get(int key) {
        int index = hash(key);
        LinkedList<Entry> existingItem = linkedLists[index];
        if (existingItem == null) return null;
        if (!existingItem.isEmpty()) {
            for (Entry item : existingItem) {
                if (item.key == key) {
                    return item.value;
                }
            }
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        LinkedList<Entry> existingItem = linkedLists[index];
        if (existingItem == null) return;
        if (!existingItem.isEmpty()) {
            for (Entry item : existingItem) {
                if (item.key == key) {
                    existingItem.remove(item);
                }
            }
        }
    }

    private int hash(int key) {
        return key % linkedLists.length;
    }

    public void put(int key) {
        int index = hash(key);
        if (linkedLists[index] == null) {
            linkedLists[index] = new LinkedList<>();
        }
        LinkedList<Entry> existingItem = linkedLists[index];
        if (!existingItem.isEmpty()) {
            for (Entry item : existingItem) {
                if (item.key == key) {
                    item.value = String.valueOf(Integer.parseInt(item.value) + 1);
                    return;
                }
            }
        }
        linkedLists[index].add( new Entry(key, "1"));
    }

    public int mostRepeatedElement() {
        int key = -1;
        int biggerCount = 0;
        for (LinkedList<Entry> item : linkedLists) {
            for (Entry entryItem : item) {
                int value = Integer.parseInt(entryItem.value);
                if (biggerCount < value) {
                    biggerCount = value;
                    key = entryItem.key;
                }
            }
        }
        return key;
    }
}
