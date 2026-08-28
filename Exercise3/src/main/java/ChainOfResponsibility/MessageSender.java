package ChainOfResponsibility;

import java.util.Objects;

public abstract class MessageSender {
    private MessageCategory messageCategory;
    private MessageSender nextMessageSender;

    public MessageSender(MessageCategory messageCategory) {
        this.messageCategory = messageCategory;
    }

    public void setNextMessager(MessageSender nextMessageSender) {
        this.nextMessageSender = nextMessageSender;
    }

    public void sendMessageManager(String message, MessageCategory messageCategory) {
        if (Objects.equals(this.messageCategory, messageCategory)) {
            write(message);
        } else if (nextMessageSender != null) {
            nextMessageSender.sendMessageManager(message, messageCategory);
        }
    }

    public abstract void write(String message);
}
