package Adapter;

import Builder.Server;

public class LegacyServerAdapter implements Server {
    LegacyServer legacyServer = new LegacyServer();

    public LegacyServerAdapter(LegacyServer legacyServer) {
        this.legacyServer = legacyServer;
    }

    @Override
    public void run() {
        legacyServer.openServer();
    }

    @Override
    public void stop() {
        legacyServer.closeServer();
    }
}
