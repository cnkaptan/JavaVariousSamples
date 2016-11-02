package Thread.book.Java_Threads_2nd_Edition.chapter_2;

import java.applet.Applet;

/**
 * Created by cihankaptan on 31/10/16.
 */
public class OurApplet extends Applet {

    @Override
    public void init() {
        super.init();

        long start = System.currentTimeMillis();
        OurClass oc = new OurClass();
        oc.start();
        System.out.println(System.currentTimeMillis()-start);
    }
}
