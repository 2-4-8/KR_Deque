/**
 * Created by 248 on 06.05.2017.
 * Main class that start the app work
 */
public class Launcher {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        DequeIntSortable deque = new DequeIntSortable();
        deque.print();
        deque.addFirst(5);
        deque.addLast(7);
        deque.addLast(9);
        deque.addFirst(3);
        deque.print();
        deque.deleteLast();
        deque.deleteFirst();
        deque.print();
        for (int i=0;i<40;i++) {
            deque.addFirst(i*10);
            deque.print();
        }
    }

}
