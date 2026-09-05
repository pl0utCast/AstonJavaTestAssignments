package Builder;

public class ConcreteServer implements Server {
    private final String ip;
    private final String port;

    public ConcreteServer(Builder builder) {
        this.ip = builder.ip;
        this.port = builder.port;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void run() {
        System.out.println("Server running on " + ip + ":" + port);
    }

    public void stop() {
        System.out.println("Server was stopped");
    }

    public static class Builder implements ServerBuilder<ConcreteServer> {
        private String ip;
        private String port;

        public Builder setIp(String ip) {
            this.ip = ip;
            return this;
        }

        public Builder setPort(String port) {
            this.port = port;
            return this;
        }

        public ConcreteServer build() {
            return new ConcreteServer(this);
        }
    }
}