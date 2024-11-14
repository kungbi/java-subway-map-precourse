package subway.repository;

public interface Repository<T> {
    void add(T data);

    void add(T data, int index);

    boolean deleteStation(String name);

}
