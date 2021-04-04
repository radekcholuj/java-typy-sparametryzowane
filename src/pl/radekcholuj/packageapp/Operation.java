package pl.radekcholuj.packageapp;

public interface Operation<V> {
    public boolean send();
    public V receive();
}
