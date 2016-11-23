package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect4;

/**
 * Created by cihankaptan on 03/11/16.
 */
public class IncThread implements Runnable {

    private static int shared = 0; // Shared variable
    private String name = ""; // Name of thread
    static final Object lock = new Object (); // Lock must be static!
    IncThread(String name) {
        this.name = name;
    }

    public void run() {
        synchronized (lock){
            int myShared = shared;
            System.out.println(name + " read shared = " + myShared);
            myShared++;
            shared = myShared;
            System.out.println(name + " assigned to shared: " + myShared);
        }

    }

}


