package Thread;

/**
 * Created by cnkaptan on 4/27/15.
 */
public class ExtendThread extends Thread {

    ExtendThread(String name){
        super(name);
        start();
    }


    public void run() {
        System.out.println(getName() + " starting.");
        try {
            for(int count=0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + getName() +
                        ", count is " + count);
            }
        }
        catch(InterruptedException exc) {
            System.out.println(getName() + " interrupted.");
        }
        System.out.println(getName() + " terminating.");
    }
}


class ThreadMain {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");
        ExtendThread mt = new ExtendThread("Child #1");
        for(int i=0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread ending.");
    }
}
