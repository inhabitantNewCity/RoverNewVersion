package niit.summer.messaging;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        for (int i=0;i<5;i++){
            new Thread(new ProducerImpl()).start();
            new Thread(new ConsumerImpl(random.nextInt(100)).start();
        }

    }
}
