package Thread.book.Java_Threads_2nd_Edition.chapter_5;

import java.util.Vector;

/**
 * Created by cihankaptan on 23/11/16.
 */
public class MsgQueue {
    Vector queue = new Vector();

    public synchronized void send(Object obj){
        queue.add(obj);
    }

    public synchronized Object recv(){
        if (queue.size() == 0) return null;

        Object obj = queue.firstElement();
        queue.removeElementAt(0);
        return obj;
    }
}
