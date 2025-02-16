package coding.test.datastructure.with_java_easily.ch5;

public class CircularLinkedList<E> implements ListInterface<E> {
    private Node<E> tail;
    private int size;
    private final int NOT_FOUND = -12345;

    public CircularLinkedList() {
        size = 0;
        tail = new Node(-1);
        tail.next = tail;
    }

    @Override
    public void add(int index, E element) {
        if (index >= 0 && index <= size) {
            Node<E> prev = getNode(index - 1);
            Node<E> newNode = new Node(element, prev.next);
            prev.next = newNode;
            if (index == size)
                tail = newNode;
            size++;
        }
    }

    @Override
    public void append(E element) {
        Node<E> prev = tail; // 더미 노드
        Node<E> newNode = new Node(element, prev.next);
        prev.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index < size) {
            Node<E> prev = getNode(index - 1);
            E rElement = prev.next.element;
            prev.next = prev.next.next;
            if (index == size - 1)
                tail = prev;
            size--;
            return rElement;
        } else return null;
    }

    @Override
    public boolean removeItem(E element) {
        Node<E> cur = tail.next; // 더미 헤드
        Node<E> prev;
        for (int i = 0; i < size; i++) {
            prev = cur;
            cur = cur.next;
            if (element.equals(cur.element)) {
                prev.next = cur.next;
                size--;
                return true;
            }
        }
        return false; // not found
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index < size)
            return getNode(index).element;
        else
            throw new IndexOutOfBoundsException();
    }

    @Override
    public void set(int index, E element) {
        if (index >= 0 && index < size)
            getNode(index).element = element;
        else
            throw new IndexOutOfBoundsException();
    }

    private Node<E> getNode(int index) {
        if (index >= -1 && index < size) {
            Node<E> cur = tail.next; // 더미 헤드
            for (int i = 0; i <= index; i++)
                cur = cur.next;
            return cur;
        } else
            throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(E element) {
        Node<E> cur = tail.next; // 더미 헤드
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            if (element.equals(cur.element))
                return i;
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
        tail.next = tail;
        size = 0;
        tail = new Node(-1);
    }
}
