package niit.summer.messaging;

public interface Consumer extends Runnable {

    boolean consume();
}
