package builder;

public interface ServerBuilder<T> {
    public ServerBuilder<T> ip(String ip);

    public ServerBuilder<T> port(String port);

    public T build();

}
