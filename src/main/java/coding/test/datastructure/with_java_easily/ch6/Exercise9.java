package coding.test.datastructure.with_java_easily.ch6;

public class Exercise9<E> implements StackInterface<E> {
    private E[] stack;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null;

    public Exercise9() {
        stack = (E[]) new Object[DEFAULT_CAPACITY];
        topIndex = -1;
    }

    public Exercise9(int n) {
        stack = (E[]) new Object[n];
        topIndex = -1;
    }

    @Override
    public void push(E newElement) {
        if (isFull()) whenStackIsFull(stack.length);
        else stack[++topIndex] = newElement;
    }

    @Override
    public E pop() {
        if (isEmpty()) return ERROR;
        else return stack[topIndex--];
    }

    @Override
    public E peek() {
        if (isEmpty()) return ERROR;
        else return stack[topIndex];
    }

    public boolean isFull() {
        return (topIndex == stack.length - 1);
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public void popAll() {
        stack = (E[]) new Object[stack.length];
        topIndex = -1;
    }

    public void whenStackIsFull(int size) {
        E[] copiedStack = (E[]) new Object[size*2];

        for (int i = 0; i < size; i++) {
            copiedStack[i] = stack[i];
        }
        this.stack = copiedStack;
    }
}
