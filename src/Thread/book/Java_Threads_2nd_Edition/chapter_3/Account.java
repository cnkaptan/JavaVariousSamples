package Thread.book.Java_Threads_2nd_Edition.chapter_3;

/**
 * Created by cnkaptan on 06/11/2016.
 */
public class Account {
    private float total;
    private BusyFlag1 flag = new BusyFlag1();
    public boolean deduct(float t) {
        boolean succeed = false;
        flag.getBusyFlag();
        if (t <= total) {
            total -= t;
            succeed = true;
        }
        flag.freeBusyFlag();
        return succeed;
    }
}