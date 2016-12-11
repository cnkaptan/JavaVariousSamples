package Thread.book.Java_Threads_2nd_Edition.chapter_3;

/**
 * Created by cihankaptan on 04/11/16.
 */
public class RunnerSmlAsyncRead {

    public static void main(String[] args){
        SmlAsyncRead smlAsyncRead = new SmlAsyncRead();
        smlAsyncRead.start();
        while (true){
            String result = smlAsyncRead.getResult();
        }
    }
}
