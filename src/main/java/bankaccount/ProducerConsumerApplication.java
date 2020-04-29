package bankaccount;

import bankaccount.threads.TransactionProducer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerApplication {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        while(true) {
            executorService.submit(new TransactionProducer());
            executorService.submit(new TransactionProducer());
            executorService.submit(new TransactionProducer());


        }
    }
}
