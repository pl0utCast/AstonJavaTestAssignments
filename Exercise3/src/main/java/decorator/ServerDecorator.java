package decorator;

import builder.Server;

public abstract class ServerDecorator implements Server {
    Server realServer;

    public ServerDecorator(Server realServer) {
        this.realServer = realServer;
    }
}