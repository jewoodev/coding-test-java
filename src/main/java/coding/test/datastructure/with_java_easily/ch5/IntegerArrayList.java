package coding.test.datastructure.with_java_easily.ch5;

public class IntegerArrayList implements IntegerListInterface {
    private Integer[] item;
    private int numItems;
    private static final int DEFAULT_SIZE = 64;
    private final int NOT_FOUND = -12345;

    public IntegerArrayList() {
        item = new Integer[DEFAULT_SIZE];
        numItems = 0;
    }

    public IntegerArrayList(int size) {
        item = new Integer[size];
        numItems = 0;
    }

    @Override
    public void add(int index, Integer x) {
        if (numItems >= item.length || index < 0 || index > numItems) {
            throw new RuntimeException("Index out of bounds");
        } else {
            for (int i = numItems - 1; i >= index; i--) {
                item[i + 1] = item[i]; // shift right
            }
            item[index] = x;
            numItems++;
        }
    }

    @Override
    public void append(Integer x) {
        if (numItems >= item.length) {
            throw new RuntimeException("List full");
        } else {
            item[numItems++] = x;
        }
    }

    @Override
    public Integer remove(int index) {
        if (isEmpty() || index < 0 || index > numItems - 1) {
            throw new RuntimeException("Index out of bounds");
        } else {
            Integer temp = item[index];
            for (int i = index; i < numItems - 1; i++) {
                item[i] = item[i + 1]; // shift left
            }
            numItems--;
            return temp;
        }
    }

    @Override
    public boolean removeItem(Integer x) {
        int k = 0;
        while (k < numItems && item[k].compareTo(x) != 0) {
            k++;
        }
        if (k == numItems) {
            return false;
        } else {
            for (int i = k; i < numItems - 1; i++) {
                item[i] = item[i + 1]; // shift left
            }
            numItems--;
            return true;
        }
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index > numItems - 1) {
            throw new RuntimeException("Index out of bounds");
        } else {
            return item[index];
        }
    }

    @Override
    public void set(int index, Integer x) {
        if (index < 0 || index > numItems - 1) {
            throw new RuntimeException("Index out of bounds");
        } else {
            item[index] = x;
        }
    }

    @Override
    public int indexOf(Integer x) {
        for (int i = 0; i < numItems; i++) {
            if (item[i].compareTo(x) == 0) {
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
        item = new Integer[item.length];
        numItems = 0;
    }
}
