package niit.summer.messaging;

public interface MessageBus {

    void put(Message message) throws InterruptedException;

    Message take() throws InterruptedException;

    int queueSize();
}
