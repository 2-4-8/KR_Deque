import com.sun.javafx.collections.SortableList;

/**
 * Created by 248 on 07.05.2017.
 *
 */
public class DequeIntSortable extends DequeImpl<Integer> implements Sortable{

    public DequeIntSortable() {
        super();
    }

    public DequeIntSortable(int capacity) {
        super(capacity);
    }

    public DequeIntSortable(Integer[] source) {
        super(source);
    }

    @Override
    public boolean isSorted() {
        DequeImpl<Integer> currentDeque = DequeImpl.copyDeque(this);
        DequeImpl<Integer> tmpDeque = new DequeImpl<>();
        while (!currentDeque.isEmpty()) {
            if (tmpDeque.isEmpty()) {
                tmpDeque.addLast(currentDeque.deleteFirst());
            } else {
                if (currentDeque.getFirst() < tmpDeque.getLast()) return false;
                tmpDeque.addLast(currentDeque.deleteFirst());
            }
        }
        return true;
    }

    @Override
    public void sort() {
        assert (isEmpty() || size() == 1);
        boolean swapped;
        do {
            swapped = false;
            int n = size();
            for (int i=0;i<n-1;i++) {
                int first = deleteFirst();
                int second = deleteFirst();
                if (second < first) {
                    swapped = true;
                    addLast(second);
                    addFirst(first);
                } else {
                    addLast(first);
                    addFirst(second);
                }
            }
            addLast(deleteFirst());
        } while (swapped);
    }
}
