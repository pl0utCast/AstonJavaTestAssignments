package ProxyPattern;

import Builder.ConcreteServer;

public class ProxyServer {
    final ConcreteServer realServer;

    public ProxyServer(ConcreteServer realServer){
        this.realServer = realServer;
    }

    public void run(){
        System.out.println("Some cache before");
        realServer.run();
        System.out.println("Some logs after");
    }

    public void stop(){
        realServer.stop();
        System.out.println("Close db");
    }
}
