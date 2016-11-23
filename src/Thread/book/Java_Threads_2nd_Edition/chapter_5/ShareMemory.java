package Thread.book.Java_Threads_2nd_Edition.chapter_5;

import Thread.book.Java_Threads_2nd_Edition.chapter_4.BusyFlag;

/**
 * Created by cihankaptan on 23/11/16.
 */
public class ShareMemory extends BusyFlag {
    byte[] memory;

    public ShareMemory(int size) {
        memory = new byte[size];
    }

    public synchronized byte[] attach(){
        getBusyFlag();
        return memory;
    }

    public synchronized void detach(){
        freeBusyFlag();
    }
}
