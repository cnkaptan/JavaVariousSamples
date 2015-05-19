package Thread;

/**
 * Created by cnkaptan on 4/28/15.
 */
public class CounterTest {
    public static void main(String[] args) {

        Counter counter = new Counter();

        Thread t1 = new Thread(counter,"Thread1");
        Thread t2 = new Thread(counter,"Thread2");

        t1.start();
        t2.start();

        System.out.println(counter.c);

    }
}

class Counter implements Runnable {

    @Override
    public void run() {
        increment();
        decrement();
    }

    int c = 0;

    public void increment() {

        c++;
        System.out.println(c +" "+Thread.currentThread().getName()+" incerement");
    }

    public void decrement() {
        c--;
        System.out.println(c +" "+Thread.currentThread().getName()+" decrement");

    }

    public int value() {
        return c;
    }

}