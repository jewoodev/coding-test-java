package coding.test.datastructure.with_java_easily.ch5;

public class CircularDoublyLinkedList<E> implements ListInterface<E> {
    private BidirectionalNode<E> head;
    private int size;
    private final int NOT_FOUND = -12345;

    public CircularDoublyLinkedList() {
        size = 0;
        head = new BidirectionalNode<>(null); // 더미 헤드
        head.next = head.prev = head;
    }

    @Override
    public void add(int index, E element) {
        if (index >= 0 && index <= size) {
            BidirectionalNode<E> prev = getNode(index - 1);
            BidirectionalNode<E> newNode = new BidirectionalNode<>(prev, element, prev.next);
            newNode.next.prev = newNode;
            prev.next = newNode;
            size++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void append(E element) {
        BidirectionalNode<E> prev = head.prev;
        BidirectionalNode<E> newNode = new BidirectionalNode<>(prev, element, head);
        prev.next = newNode;
        head.prev = newNode;
        size++;
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index < size) {
            BidirectionalNode<E> cur = getNode(index);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            size--;
            return cur.element;
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean removeItem(E element) {
        BidirectionalNode<E> cur = head; // 더미 헤드
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

    @Override
    public E get(int index) {
        if (index >= 0 && index < size) {
            return getNode(index).element;
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public void set(int index, E element) {
        if (index >= 0 && index < size) {
            getNode(index).element = element;
        } else throw new IndexOutOfBoundsException();
    }

    private BidirectionalNode<E> getNode(int index) {
        if (index >= -1 && index < size) {
            BidirectionalNode<E> cur = head;
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

    @Override
    public int indexOf(E element) {
        BidirectionalNode<E> cur = head;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            if (cur.element.equals(element)) return i;
        }
        return NOT_FOUND;
    }

    @Override
    public int len() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        head.next = head.prev = head;
    }
}
