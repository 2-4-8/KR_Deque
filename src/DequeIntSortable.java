import com.sun.javafx.collections.SortableList;

/**
 * Created by 248 on 07.05.2017.
 *
 */
public class DequeIntSortable extends DequeImpl<Integer> implements Sortable{

    @Override
    public boolean isSorted() {
        return false;
    }

    @Override
    public void sort() {

    }
}
