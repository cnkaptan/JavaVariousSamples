package Thread.book.Java_Threads_2nd_Edition.chapter_2;

/**
 * Created by cihankaptan on 31/10/16.
 */
public class OurClass extends Thread {

    public void run(){
        for (int i = 0; i < 10000; i++) {
            System.out.println("Hello");
        }
    }
}
