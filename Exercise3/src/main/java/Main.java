import Adapter.LegacyServer;
import Adapter.LegacyServerAdapter;
import ChainOfResponsibility.*;
import Strategy.JsonReader;
import Strategy.StudentService;
import Strategy.TxtReader;
import Builder.ConcreteServer;
import Decorator.LoggingServerDecorator;


static void main() {
    System.out.println("Strategy usage");
    StudentService studentService1 = new StudentService(new JsonReader());
    studentService1.readFile();
    StudentService studentService2 = new StudentService(new TxtReader());
    studentService2.readFile();

    System.out.println("\nBuilder usage");
    ConcreteServer server = ConcreteServer.builder()
            .setIp("127.0.0.1")
            .setPort("8080")
            .build();
    server.run();
    server.stop();

    System.out.println("\nProxy usage");
    ProxyPattern.ProxyServer serverProxy = new ProxyPattern.ProxyServer(server);
    serverProxy.run();
    server.stop();

    System.out.println("\nDecorator usage");
    LoggingServerDecorator loggingServer = new LoggingServerDecorator(server);
    loggingServer.run();
    loggingServer.getServerInfo();
    loggingServer.stop();

    System.out.println("\nAdapter usage");
    LegacyServer legacyServer = new LegacyServer();
    LegacyServerAdapter legacyServerAdapter = new LegacyServerAdapter(legacyServer);
    legacyServerAdapter.run();
    legacyServerAdapter.stop();

    System.out.println("\nChain of responsibility usage");
    MessageSender debugSender = new DebugMessageSender(MessageCategory.DEBUG);
    MessageSender errorSender = new ErrorMessageSender(MessageCategory.ERROR);
    MessageSender infoSender = new InfoMessageSender(MessageCategory.INFO);
    debugSender.setNextMessager(errorSender);
    errorSender.setNextMessager(infoSender);
    debugSender.sendMessageManager("its info message incoming", MessageCategory.INFO);
    debugSender.sendMessageManager("it's debug message incoming", MessageCategory.DEBUG);
    debugSender.sendMessageManager("it's error message incoming", MessageCategory.ERROR);
}