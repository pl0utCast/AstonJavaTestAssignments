package ChainOfResponsibility;

public class ErrorMessageSender extends MessageSender {

    public ErrorMessageSender(MessageCategory messageCategory) {
        super(messageCategory);
    }

    @Override
    public void write(String message) {
        System.out.println("Error message" + message);
    }
}
