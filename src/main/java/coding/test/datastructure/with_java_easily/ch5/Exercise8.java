package coding.test.datastructure.with_java_easily.ch5;

public class Exercise8 {
    public static class CircularDoublyLinkedList {
        private BidirectionalNode<Integer> head;
        private int size;
        private final int NOT_FOUND = -12345;

        public CircularDoublyLinkedList() {
            size = 0;
            head = new BidirectionalNode<>(null); // 더미 헤드
            head.next = head.prev = head;
        }

        public void add(int index, Integer element) {
            if (index >= 0 && index <= size) {
                BidirectionalNode<Integer> prev = getNode(index - 1);
                BidirectionalNode<Integer> newNode = new BidirectionalNode<>(prev, element, prev.next);
                newNode.next.prev = newNode;
                prev.next = newNode;
                size++;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        public void append(Integer element) {
            BidirectionalNode<Integer> prev = head.prev;
            BidirectionalNode<Integer> newNode = new BidirectionalNode<>(prev, element, head);
            prev.next = newNode;
            head.prev = newNode;
            size++;
        }

        public Integer remove(int index) {
            if (index >= 0 && index < size) {
                BidirectionalNode<Integer> cur = getNode(index);
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                size--;
                return cur.element;
            } else throw new IndexOutOfBoundsException();
        }

        public boolean removeItem(Integer element) {
            BidirectionalNode<Integer> cur = head; // 더미 헤드
            for (int i = 0; i < size; i++) {
                cur = cur.next;
                if (cur.element.equals(element)) {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                    size--;
                    return true;
                }
            }
            return false;
        }

        public Integer get(int index) {
            if (index >= 0 && index < size) {
                return getNode(index).element;
            } else throw new IndexOutOfBoundsException();
        }

        public void set(int index, Integer element) {
            if (index >= 0 && index < size) {
                getNode(index).element = element;
            } else throw new IndexOutOfBoundsException();
        }

        private BidirectionalNode<Integer> getNode(int index) {
            if (index >= -1 && index < size) {
                BidirectionalNode<Integer> cur = head;
                if (index < size / 2) {
                    for (int i = 0; i < index; i++)
                        cur = cur.next;
                } else {
                    for (int i = size - 1; i >= index; i--)
                        cur = cur.prev;
                }
                return cur;
            } else throw new IndexOutOfBoundsException();
        }

        public int indexOf(Integer element) {
            BidirectionalNode<Integer> cur = head;
            for (int i = 0; i < size; i++) {
                cur = cur.next;
                if (cur.element.equals(element)) return i;
            }
            return NOT_FOUND;
        }

        public int len() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void clear() {
            size = 0;
            head.next = head.prev = head;
        }

        public void add(int x) {
            BidirectionalNode<Integer> newNode = new BidirectionalNode<>(null, x, null);
            BidirectionalNode<Integer> cur = head.next;
            while (cur != null && cur.element < x) {
                cur = cur.next;
            }
            newNode.prev = cur.prev;
            newNode.next = cur;
            cur.prev = newNode;
        }
    }
}
