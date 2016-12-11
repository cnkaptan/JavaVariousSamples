package Thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cihankaptan on 10/11/16.
 */
public class SynchronizedQueue {
    private static List<String> q_ = new ArrayList<>();

    public synchronized static void put(String msg) {
        q_.add(msg);
        Thread.currentThread().notifyAll();
    }

    public synchronized static String take() {
        while (q_.isEmpty()) {
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return q_.remove(0);
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) put(Integer.toString(i));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(take());
                }
            }
        }).start();
    }
}
