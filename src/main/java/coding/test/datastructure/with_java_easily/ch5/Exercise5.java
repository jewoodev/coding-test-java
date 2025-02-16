package coding.test.datastructure.with_java_easily.ch5;

public class Exercise5 {
    public class LinkedList<E> implements ListInterface<E> {
        private Node<E> head;
        private int numItems;
        public final int NOT_FOUND = -12345;

        public LinkedList() {
            head = new Node<>(null, null);
            numItems = 0;
        }

        @Override
        public void add(int index, E element) {
            if (index >= 0 && index <= numItems) {
                Node<E> prev = getNode(index - 1);
                Node<E> newNode = new Node<>(element, prev.next);
                prev.next = newNode;
                numItems++;
            }
        }

        @Override
        public void append(E element) {
            Node<E> prev = head;
            while (prev.next != null) {
                prev = prev.next;
            }
            Node<E> newNode = new Node<>(element, null);
            prev.next = newNode;
            numItems++;
        }

        @Override
        public E remove(int index) {
            if (index >= 0 && index < numItems) {
                Node<E> prev = getNode(index - 1);
                Node<E> target = prev.next;
                prev.next = target.next;
                numItems--;
                return target.element;
            } else {
                throw new RuntimeException("index out of bounds");
            }
        }

        @Override
        public boolean removeItem(E element) {
            Node<E> cur = head;
            Node<E> prev;
            while (cur.next != null) {
                prev = cur;
                cur = cur.next;
                if (cur.element.equals(element)) {
                    prev.next = cur.next;
                    numItems--;
                    return true;
                }
            }
            return false; // not found
        }

        @Override
        public E get(int index) {
            if (index >= 0 && index < numItems) {
                return getNode(index).element;
            } else
                throw new RuntimeException("index out of bounds");
        }

        private Node<E> getNode(int index) {
            if (index >= -1 && index < numItems) {
                Node<E> cur = head;
                for (int i = 0; i <= index; i++) {
                    cur = cur.next;
                }
                return cur;
            } else
                throw new RuntimeException("index out of bounds");
        }

        @Override
        public void set(int index, E element) {
            if (index >= 0 && index < numItems) {
                getNode(index).element = element;
            } else
                throw new RuntimeException("index out of bounds");
        }

        @Override
        public int indexOf(E element) {
            Node<E> cur = head;
            for (int i = 0; i < numItems; i++) {
                cur = cur.next;
                if (cur.element.equals(element)) {
                    return i;
                }
            }
            return NOT_FOUND;
        }

        @Override
        public int len() {
            return numItems;
        }

        @Override
        public boolean isEmpty() {
            return numItems == 0;
        }

        @Override
        public void clear() {
            numItems = 0;
            head = new Node<>(null, null);
        }

        public void printInterval(int i, int j) {
            if (i < 0 || i >= numItems || j < 0 || j >= numItems || i > j) {
                throw new RuntimeException("index out of bounds");
            }
            Node<E> cur = head;
            for (int k = 0; k <= j; k++) {
                cur = cur.next;
                if (k >= i) {
                    System.out.print(cur.element + " ");
                }
            }
            System.out.println();
        }
    }
}
