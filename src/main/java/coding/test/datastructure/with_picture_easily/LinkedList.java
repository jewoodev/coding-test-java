package coding.test.datastructure.with_picture_easily;

class LinkedList<D> implements List {
    private Node<D> head;
    private int cnt;

    LinkedList() {
        this.head = null;
        this.cnt = 0;
    }

    @Override
    public void printAll() {
        Node<D> currentNode = head;
        StringBuilder text = new StringBuilder("{");

        while (currentNode != null) {
            text.append(currentNode.data);
            currentNode = currentNode.next;

            if (currentNode != null) {
                text.append(", ");
            }
        }

        text.append("}");
        System.out.println(text);
    }

    @Override
    public void clear() {
        head = null;
        cnt = 0;
    }

    @Override
    public <SD> void insertAt(int idx, SD data) {
        if (idx > cnt || idx < 0) {
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        }

        Node<D> newNode = new Node(data);

        if (idx == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<D> currentNode = head;

            for (int i = 0; i < idx - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        cnt++;
    }

    @Override
    public <SD> void insertLast(SD data) {
        insertAt(cnt, data);
    }

    @Override
    public Node<D> deleteAt(int idx) {
        if (idx >= cnt || idx < 0) {
            throw new IndexOutOfBoundsException("제거할 수 없습니다.");
        }

        Node<D> currentNode = head;

        if (idx == 0) {
            Node<D> deletedNode = head;
            head = head.next;
            cnt--;
            return deletedNode;
        } else {
            for (int i = 0; i < idx - 1; i++) {
                currentNode = currentNode.next;
            }

            Node<D> deletedNode = currentNode.next;
            currentNode.next = currentNode.next.next;
            cnt--;
            return deletedNode;
        }
    }

    @Override
    public Node<D> deleteLast() {
        return deleteAt(cnt - 1);
    }

    @Override
    public Node<D> getNodeAt(int idx) {
        if (idx >= cnt || idx < 0) {
            throw new IndexOutOfBoundsException("범위를 넘어갔습니다.");
        }

        Node<D> currentNode = head;
        for (int i = 0; i < idx; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    int getCount() {
        return cnt;
    }
}
