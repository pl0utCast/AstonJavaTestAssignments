package decorator;

import builder.Server;

public class LoggingServerDecorator extends ServerDecorator {

    public LoggingServerDecorator(Server wrapped) {
        super(wrapped);
    }

    @Override
    public void run() {
        System.out.println("Some logs");
        realServer.run();
    }

    @Override
    public void stop() {
        realServer.stop();
    }

    public void getServerInfo() {
        System.out.println("LoggingServerDecorator wrapping: " + realServer.getClass().getSimpleName());
    }
}