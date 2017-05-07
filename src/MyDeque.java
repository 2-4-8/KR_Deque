/**
 * Created by 248 on 06.05.2017.
 *
 */
public interface MyDeque<T> {

    public void addFirst(T t);
    public void addLast(T t);
    public T deleteFirst();
    public T deleteLast();
    public T getFirst();
    public T getLast();

    public int size();
    public boolean isEmpty();
    public void clearDeque();

}
