package chainOfResponsibility;

public class DebugMessageSender extends MessageSender {

    public DebugMessageSender(MessageCategory messageCategory) {
        super(messageCategory);
    }

    @Override
    public void write(String message) {
        System.out.println("Debug message: " + message);
    }
}
