package HashTable;

import java.util.LinkedList;

public class HashTable {

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private final LinkedList<Entry>[] table = new LinkedList[5];
    
    private int hash(int key) {
        return key % table.length;
    }

    public void put(int key, String value) {
        int index = hash(key);
        
        if (table[index] == null)
            table[index] = new LinkedList<>();
        
        var slot = table[index];
        for (var entry : slot) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        slot.addLast(new Entry(key, value));
    }

    public String get(int key) {
        int index = hash(key);
        var slot = table[index];

        if (slot != null) {
            for (var entry : slot)
                if (entry.key == key)
                    return entry.value;
        }

        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        var slot = table[index];

        if (slot != null) {
            for (var entry : slot) {
                if (entry.key == key) {
                    slot.remove(entry);
                    return;
                }
            }
        }

        throw new IllegalStateException("Key not found");
    }

}
