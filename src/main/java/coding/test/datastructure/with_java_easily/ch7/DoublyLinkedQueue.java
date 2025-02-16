package coding.test.datastructure.with_java_easily.ch7;

public class DoublyLinkedQueue implements QueueInterface { // 연습문제 1
    private DNode head;

    public DoublyLinkedQueue() {
        head = new DNode(null);
        head.prev = head;
        head.next = head;
    }

    @Override
    public void enqueue(Object o) {
        if (head.element == null)
            head = new DNode(o);
        else {
            DNode element = new DNode(o, null, head);
            head.prev= element;
            head = element;
        }
    }

    @Override
    public Object dequeue() {
        if (isEmpty())
            return null;

        DNode cur = head;
        while (cur.next != null)
            cur = cur.next;

        if (cur.prev != null)
            cur.prev.next = null;
        return cur.element;
    }

    @Override
    public Object front() {
        return isEmpty() ? null : head;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void dequeueAll() {
        head = null;
    }

    private class DNode {
        public Object element;
        public DNode prev;
        public DNode next;
        public DNode(Object element) {
            this.element = element;
            this.prev = null;
            this.next = null;
        }
        public DNode(Object element, DNode prev, DNode next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
