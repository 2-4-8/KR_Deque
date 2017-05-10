/**
 * Created by 248 on 06.05.2017.
 * Main class that start the app work
 */
public class Launcher {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        new Launcher().go();
    }

    public void go() {
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
        for (int i=0;i<10;i++) {
            deque.addFirst(i*10);
            deque.print();
        }
        System.out.println(deque.isSorted());
        deque.sort();
        deque.print();
        System.out.println(deque.isSorted());
        System.out.println(deque.size());
        System.out.println();

        deque = new DequeIntSortable(2);
        deque.addFirst(1);
        deque.addLast(2);
        System.out.println(deque.isSorted());
        System.out.println();

        deque = new DequeIntSortable(1);
        deque.addFirst(1);
        System.out.println(deque.isSorted());
        System.out.println();

        deque = new DequeIntSortable();
        System.out.println(deque.isSorted());
        System.out.println();

        deque = new DequeIntSortable(2);
        deque.addFirst(1);
        deque.addFirst(2);
        deque.print();
        System.out.println(deque.isSorted());
        deque.sort();
        deque.print();
        System.out.println(deque.isSorted());
        System.out.println();
    }

}
