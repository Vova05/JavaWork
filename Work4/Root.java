package Work4;

import java.util.concurrent.*;
import java.util.*;

public class Root {


    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(10);

        executorService.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello there too !!");
        });
        executorService.submit(() -> System.out.println("Hello there!"));
    }
}
