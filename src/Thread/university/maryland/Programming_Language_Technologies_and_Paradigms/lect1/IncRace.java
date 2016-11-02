package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect1;

/**
 * Created by cihankaptan on 02/11/16.
 */
public class IncRace {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread (new IncThread ("t1"));
        Thread t2 = new Thread (new IncThread ("t2"));
        t1.start ();
//		Thread.sleep (5);
        t2.start ();
    }
}