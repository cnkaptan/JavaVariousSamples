package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect4;

/**
 * Created by cihankaptan on 03/11/16.
 */
public class IncThreadSample {

    public static void main(String[] args){
        Thread t1 = new Thread(new IncThread("t1"));
        Thread t2 = new Thread(new IncThread("t2"));
        t1.start();
        t2.start();
    }
}
