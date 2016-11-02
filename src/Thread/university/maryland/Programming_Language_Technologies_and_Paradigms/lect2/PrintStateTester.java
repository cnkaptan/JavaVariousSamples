package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect2;

/**
 * Created by cihankaptan on 02/11/16.
 */
public class PrintStateTester {

    public static void main(String[] args){
        Thread h1 = new Thread(new HelloWorldRunnable());
        ThreadStateTester.printState(h1);
        h1.start();
        ThreadStateTester.printState(h1);
    }
}
