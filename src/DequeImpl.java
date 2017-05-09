/**
 * Created by 248 on 07.05.2017.
 *
 */
public class DequeImpl<T> implements MyDeque<T> {

    public static final int DEFAULT_CAPACITY = 8;

    private Object[] values;
    private int capacity;
    private int first;
    private int last;
    private boolean isEmpty;

    DequeImpl() {
        values = new Object[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
        first = last = 0;
        isEmpty = true;
    }

    DequeImpl(int capacity) {
        values = new Object[capacity];
        this.capacity = capacity;
        first = last = 0;
        isEmpty = true;
    }

    DequeImpl(T[] source) {
        values = new Object[source.length];
        System.arraycopy(source, 0, values, source.length-1, source.length);
        this.capacity = source.length;
        first = 0;
        last = source.length - 1;
        isEmpty = (source[0] == null);
    }

    private void redistributeElements() {
        int size = size();
        if (size>0 && first!=0) {
            Object[] newValues = new Object[capacity];
            if (last >= first) {
                System.arraycopy(values, first, newValues, 0, size);
                first = 0;
                last = size - 1;
                values = newValues;
            } else {
                int sizeToCap = capacity - first;
                System.arraycopy(values, first, newValues, 0, sizeToCap);
                System.arraycopy(values, 0, newValues, sizeToCap, last + 1);
                first = 0;
                last = size - 1;
                values = newValues;
            }
        }
    }

    private void doubleCapacity() throws Exception {
        assert (isEmpty());
        redistributeElements();
        int newCapacity = capacity * 2;
        if (newCapacity < 0) throw new Exception("Too much elements");
        Object[] newValues = new Object[newCapacity];
        System.arraycopy(values, 0, newValues, 0, size());
        values = newValues;
        capacity = newCapacity;
    }

    @Override
    public void addFirst(T o) {
        if (size() == capacity) {
            try {
                doubleCapacity();
            } catch (Exception e) {
                e.printStackTrace();
            }
            addFirst(o);
        } else {
            if (isEmpty()) {
                addToEmpty(o);
            } else {
                if (first == 0) first = capacity - 1;
                else first--;
                values[first] = o;
            }
        }
    }

    @Override
    public void addLast(T o) {
        if (size() == capacity) {
            try {
                doubleCapacity();
            } catch (Exception e) {
                e.printStackTrace();
            }
            addLast(o);
        } else {
            if (isEmpty()) {
                addToEmpty(o);
            } else {
                if (last == capacity - 1) last = 0;
                else last++;
                values[last] = o;
            }
        }
    }

    private void addToEmpty(T o) {
        values[0] = o;
        first = last = 0;
        isEmpty = false;
    }

    @Override
    public T deleteFirst() {
        T result = getFirst();
        if (size() == 1) {
            clearDeque();
        } else {
            values[first] = null;
            if (first == capacity - 1) first = 0; else first++;
        }
        return result;
    }

    @Override
    public T deleteLast() {
        T result = getLast();
        if (size() == 1) {
            clearDeque();
        } else {
            values[last] = null;
            if (last == 0) last = capacity - 1; else last--;
        }
        return result;
    }

    @Override
    public T getFirst() {
        @SuppressWarnings("unchecked")
        T result = (T) values[first];
        return result;
    }

    @Override
    public T getLast() {
        @SuppressWarnings("unchecked")
        T result = (T) values[last];
        return result;
    }

    @Override
    public int size() {
        if (isEmpty()) return 0;
        return (last >= first ? last - first : last + (capacity - first)) + 1;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public void clearDeque() {
        for (Object o: values) {
            o = null;
        }
        first = last = 0;
        isEmpty = true;
    }

    public void print() {
        if (isEmpty()) System.out.print("Deque is empty");
        for (Object o: values) {
            if (o != null && !isEmpty()) {
                System.out.print(o);
                if (values[first].equals(o)) System.out.print("(F)");
                if (values[last].equals(o)) System.out.print("(L)");
                System.out.print(" ");
            }
        }
        System.out.print("\n");
    }
}
