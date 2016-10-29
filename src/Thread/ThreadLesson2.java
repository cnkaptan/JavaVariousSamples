package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by cihankaptan on 26/10/16.
 */
public class ThreadLesson2 {

    /**
     * ExecutorService bize belli bir anda en fazla kaç Thread çalıştırmak istediğimizi sorar.
     * Yukarıdaki örnek newFixedThreadPool metodu ile 5 farklı iş parçasının aynı anda çalıştırılabileceği belirtilmiştir.
     * Daha sonrasında for döngüsü içinde 20 adet Thread tanımlanmasına rağmen executor servisi gelen işleri düzene sokar
     * ve 5 Thread üzerinde işlem gerçekleştirmez. Sonradan eklenen işlemler sıraya (queue) sokulur ve
     * mevcut işlemler bitirildikçe çalıştırılır. Böylece sistem kaynakları işlem parçaları tarafından kontrolsüzce harcanamaz.
     * shutdown metodu ise yeni işlem alımını durdurur ve mevcut işlemlerin bitirilmesini sağlar.
     * awaitTermination ise mevcut işlemlerin bitirilmesi için belirli bir süre tanır ve
     * bu sürenin sonunda ExecutorService tamamen kapatılır.
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(new MyThread("thread" + i, 3));
            executor.execute(thread);
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Done");
    }

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
