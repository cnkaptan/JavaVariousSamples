package Thread;

/**
 * Created by cihankaptan on 03/11/16.
 */
public class CurrentThreadSample {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello World");

        printThreadName();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        printThreadName();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Isci");
        thread.start();
        thread.join();
        printThreadName();

    }

    private static void printThreadName() {
        System.out.println(Thread.currentThread().getName());
    }

}
