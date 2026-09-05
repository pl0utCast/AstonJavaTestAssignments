package Builder;

public interface ServerBuilder<T> {
    public ServerBuilder<T> setIp(String ip);

    public ServerBuilder<T> setPort(String port);

    public T build();

}
