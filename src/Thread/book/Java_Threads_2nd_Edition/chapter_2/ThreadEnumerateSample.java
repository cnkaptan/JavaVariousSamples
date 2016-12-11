package Thread.book.Java_Threads_2nd_Edition.chapter_2;

/**
 * Created by cihankaptan on 03/11/16.
 */
public class ThreadEnumerateSample {

    public static void main(String[] args){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Other Thread");

        thread.start();
        Thread ta[] = new Thread[Thread.activeCount()];
        int n = Thread.enumerate(ta);
        for (int i = 0; i < n; i++) {
            System.out.println("Thread " + i + " is " +
                    ta[i].getName());
        }
    }
}
