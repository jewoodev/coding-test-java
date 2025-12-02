package coding.test.datastructure.with_picture_easily;

interface List {
    void printAll();
    void clear();
    <D> void insertAt(int idx, D data);
    <D> void insertLast(D data);
    Node deleteAt(int idx);
    Node deleteLast();
    Node getNodeAt(int idx);
}
