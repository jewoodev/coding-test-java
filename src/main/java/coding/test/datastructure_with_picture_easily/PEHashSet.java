package coding.test.datastructure_with_picture_easily;

public class PEHashSet<K, V> {
    PEHashTable hashTable;

    public PEHashSet() {
        this.hashTable = new PEHashTable();
    }

    void add(K key) throws Exception {
        if (hashTable.get(key) == null) {
            hashTable.put(key, -1);
        }
    }

    boolean isContain(K key) {
        return hashTable.get(key) != null;
    }

    void remove(K key) {
        this.hashTable.remove(key);
    }

    void clear() {
        for (int i = 0; i < this.hashTable.arr.length; i++) {
            this.hashTable.arr[i].clear();
        }
    }

    boolean isEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < this.hashTable.arr.length; i++) {
            if (this.hashTable.arr[i].count > 0) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    void printAll() {
        for (int i = 0; i < this.hashTable.arr.length; i++) {
            PEHashTable.HashData curData = this.hashTable.arr[i].head;
            while (curData != null) {
                System.out.println(curData.key);
                curData = curData.next;
            }
        }
    }
}
