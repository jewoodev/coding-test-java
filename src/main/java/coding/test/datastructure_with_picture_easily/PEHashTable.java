package coding.test.datastructure_with_picture_easily;

public class PEHashTable<K, V> {
    DoublyLinkedList<K, V>[] arr = new DoublyLinkedList[10];
    public PEHashTable() {
        for (int i = 0; i < 10; i++) {
            this.arr[i] = new DoublyLinkedList();
        }
    }

    int hashFunction(K number) {
        return (int) number % 10;
    }

    void put(K key, V value) throws Exception {
        this.arr[hashFunction(key)].insertAt(0, new HashData(key, value));
    }

    V get(K key) {
        HashData curData = this.arr[hashFunction(key)].head;

        while (curData != null) {
            if (curData.key == key)
                return (V) curData.value;
            curData = curData.next;
        }
        return null;
    }

    HashData<K, V> remove(K key) {
        DoublyLinkedList list = this.arr[hashFunction(key)];
        HashData curData = list.head;
        int IdxForDelete = 0;
        while (curData != null) {
            if (curData.key == key)
                return list.deleteAt(IdxForDelete);
            curData = curData.next;
            IdxForDelete++;
        }
        return null;
    }

    static class HashData<K, V> {
        K key;
        V value;
        HashData prev;
        HashData next;
        private HashData(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    static class DoublyLinkedList<K, V> {
        HashData head;
        HashData tail;
        int count;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
            this.count = 0;
        }

        void printAll() {
            HashData curHashData = this.head;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (curHashData != null) {
                sb.append(curHashData.value);
                curHashData = curHashData.next;
                if (curHashData != null) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            System.out.println(sb);
        }

        void clear() {
            this.head = null;
            this.count = 0;
        }

        void insertAt(int index,  HashData data) throws Exception {
            if (index > this.count || index < 0) {
                throw new Exception("범위를 벗어났습니다.");
            }

            HashData newHashData = data;

            if (index == 0) {
                newHashData.next = this.head;
                // 비어있는 리스트가 아니면
                if (this.head != null) {
                    this.head.prev = newHashData; // 이전 참조 관계를 만든다.
                }
                this.head = newHashData;
            } else if (index == this.count) { // 리스트 끝에 삽입하려하면
                newHashData.next = null;
                newHashData.prev = this.tail;
                this.tail.next = newHashData;
            } else { // 중앙에 삽입하려 하면
                HashData curHashData = this.head;
                for (int i = 0; i < index - 1; i++) { // 머리 노드에서 삽입하기 전의 노드로 이동
                    curHashData = curHashData.next;
                }

                newHashData.next = curHashData.next;
                newHashData.prev = curHashData;
                curHashData.next = newHashData;
                newHashData.next.prev = newHashData;
            }

            if (newHashData.next == null) {
                this.tail = newHashData;
            }
            this.count++;
        }

        HashData<K, V> deleteAt(int index) {
            if (index >= this.count || index < 0) {
                throw new Error("제거할 수 없는 요소를 선택하셨습니다.");
            }

            HashData<K, V> curHashData = this.head;

            if (index == 0) {
                HashData<K, V> forDelete = this.head;
                // 노드가 하나 있는 리스트면
                if (this.head.next == null) {
                    this.head = null;
                    this.tail = null;
                } else {
                    this.head = this.head.next;
                    this.head.prev = null;
                }
                this.count--;
                return forDelete;
            } else if (index == this.count - 1) {
                HashData<K, V> forDelete = this.tail;
                this.tail.prev.next = null;
                this.tail = this.tail.prev;
                this.count--;
                return forDelete;
            } else {
                for (int i = 0; i < index - 1; i++) {
                    curHashData = curHashData.next;
                }
                HashData<K, V> forDelete = curHashData.next;
                curHashData.next = curHashData.next.next;
                curHashData.next.prev = curHashData;
                this.count--;
                return forDelete;
            }
        }
    }
}
