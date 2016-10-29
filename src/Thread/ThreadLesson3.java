package Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by cihankaptan on 26/10/16.
 */
public class ThreadLesson3 {

    /**
     * Tanımlanan işlemlerin belirli bir zaman sonra otomatik başlatılması ya da
     * sistematik olarak belli bir frekansla çalıştırılması için Java bizlere ScheduledExecutorService adında bir sınıf sunar.
     * Bu sistem sayesinde yapılan işlemlerin belirli bir tarihte başlamasını ya da
     * sürekli olarak işlemin tekrar edilmesini sağlayabiliriz.
     */
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        MyThread worker = new MyThread("Thread 1", 3);
        pool.schedule(worker, 5, TimeUnit.SECONDS);
        Thread.sleep(20000);
        pool.shutdown();

    }

    /**
     * Yukarıdaki örnekte ExecutorService yerine ScheduledExecutorService kullanılarak işlemin ileri bir tarihte gerçekleşmesi sağlanır.
     * schedule metodu ile verilen iş parçası 5 saniye gecikmeli çalışacaktır.
     * Thread.sleep metodu ise ana akışı durdurur ancak MyThread ile tanımlanan worker iş parçası ScheduledExecutorService tarafından çalıştırılır.
     * Dilerseniz scheduleAtFixedRate metodu ile işlemin sürekli çalışmasını sağlayabilirsiniz.
     */

    private static class MyThread implements Runnable {
        private int end;
        private String name;

        public MyThread(String name, int end) {
            this.end = end;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < end; i++) {
                System.out.println(name + " : " + i);
            }
        }
    }
}
