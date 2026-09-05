package chainOfResponsibility;

public class InfoMessageSender extends MessageSender {

    public InfoMessageSender(MessageCategory messageCategory) {
        super(messageCategory);
    }

    @Override
    public void write(String message) {
        System.out.println("Info message: " + message);
    }
}
