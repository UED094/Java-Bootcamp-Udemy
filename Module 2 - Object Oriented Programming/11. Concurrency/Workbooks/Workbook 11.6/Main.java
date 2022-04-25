import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static String[] files = new String[] { "data/sales1.csv", "data/sales2.csv", "data/sales3.csv" };
    static AtomicInteger sampleSize = new AtomicInteger(0);
    static AtomicInteger quantitySold = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {

        CountDownLatch latch = new CountDownLatch(3);
        int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        for (String file : files) {
            executor.submit(() -> increment(file, latch));
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name to access the Global Superstore data: ");
        String name = scan.nextLine();
        System.out.println("\nThank you " + name + ".\n");
        scan.close();
        latch.await();
        executor.shutdown();

        System.out.println(sampleSize.get());
        System.out.println(quantitySold.get());

    }

    public static void increment(String file, CountDownLatch latch) {
        try {
            Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(file).toURI());
            Files.lines(path)
                    .skip(1)
                    .mapToInt((line) -> Integer.parseInt(line.split(",")[2]))
                    .forEach((quantity) -> {
                        sampleSize.addAndGet(1);
                        quantitySold.addAndGet(quantity);
                    });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        latch.countDown();
    }

}
