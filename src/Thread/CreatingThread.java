package Thread;

/**
 * Created by cnkaptan on 5/8/15.
 */
public class CreatingThread {

    public static void main(String[] args){
        new Thread(new HelloRunnable()).start();
        new HelloThread().start();
    }
}

class HelloRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("HelloRunnable'dan Selamlar!");
    }
}

class HelloThread extends Thread{
    @Override
    public void run() {
        System.out.println("HelloThread'den Selamlar!");
    }
}
