/**
 * Created by 248 on 06.05.2017.
 * Main class that start the app work
 */
public class Launcher {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        DequeImpl<Integer> deque = new DequeImpl<>();
        deque.print();
        deque.addLast(1);
        deque.print();
        deque.addLast(2);
        deque.print();
        deque.addFirst(6);
        deque.print();
        for (int i=0;i<10;i++) {
            deque.addLast(i*5);
            deque.print();
        }
        deque.deleteFirst();
        deque.print();
        for (int i=0;i<12;i++) {
            deque.deleteLast();
            deque.print();
        }
    }

}
