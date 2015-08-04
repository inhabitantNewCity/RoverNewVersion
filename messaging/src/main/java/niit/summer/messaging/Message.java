package niit.summer.messaging;

public class Message {

    private int i;

    public Message(int i) {

        this.i = i;
    }

    public int getPayload() {
        return i;
    }
}
