package coding.test.datastructure.with_picture_easily.list;

class Node<D> {
    D data;
    Node next;

    Node(D data) {
        this(data, null);
    }

    private Node(D data, Node next) {
        this.data = data;
        this.next = next;
    }
}
