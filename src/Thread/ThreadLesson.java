package Thread;

/**
 * Created by cihankaptan on 26/10/16.
 */
public class ThreadLesson {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread("thread1", 10));
        Thread thread2 = new Thread(new MyThread("thread2", 10));
        Thread thread3 = new Thread(new MyThread("thread3", 10));
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static class MyThread implements Runnable{
        private int end;
        private String name;

        public MyThread(String name,int end) {
            this.end = end;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < end; i++) {
                System.out.println(name + " : " + i);
            }
        }
    }
}
