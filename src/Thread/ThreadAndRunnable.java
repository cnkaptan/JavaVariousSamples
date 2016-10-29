package Thread;

/**
 * Created by cihankaptan on 17/08/16.
 */
public class ThreadAndRunnable {
    public static void main(String[] args) {

        threadFundamentals(args);
    }

    private static void threadFundamentals(String[] args) {
        boolean isDaemon = args.length != 0;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Thread thd = Thread.currentThread();
                for (int i = 0; i < 10 ; i++){
                    System.out.printf("%s is %salive and in %s " +
                                    "state%n",
                            thd.getName(),
                            thd.isAlive() ? "" : "not ",
                            thd.getState());
                }
            }
        };

        Thread t1 = new Thread(r, "thd1");
        if (isDaemon)
            t1.setDaemon(true);
        System.out.printf("%s is %salive and in %s state%n",
                t1.getName(),
                t1.isAlive() ? "" : "not ",
                t1.getState());

        Thread t2 = new Thread(r);
        t2.setName("thd2");
        if (isDaemon)
            t2.setDaemon(true);
        System.out.printf("%s is %salive and in %s state%n",
                t2.getName(),
                t2.isAlive() ? "" : "not ",
                t2.getState());

        t1.start();
        t2.start();
    }

    private static void runSimplestThreads() {
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };

        Thread t1 = new Thread(r, "thread t1");
        System.out.println(t1.getName());

        Thread t2 = new Thread(r);
        t2.setName("thread t2");
        System.out.println(t2.getName());
        /*
            • NEW: A thread that has not yet started is in this state.
            • RUNNABLE: A thread executing in the JVM is in this state.
            • BLOCKED: A thread that is blocked waiting for a monitor lock is in this state.
            • WAITING: A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
            • TIMED_WAITING: A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
            • TERMINATED: A thread that has exited is in this state.
         */
        System.out.println(t2.getState());
    }
}
