import java.util.concurrent.TimeUnit;

/**
 * create by whr on 2023/3/5
 */
public class HelloWorld {

    static volatile boolean run = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while (run) {

            }
        }).start();

        run = false;
        TimeUnit.SECONDS.sleep(1000);
    }
}
