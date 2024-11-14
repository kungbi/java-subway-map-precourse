package subway.repository;

public interface Repository<T> {
    void add(T data);

    boolean deleteStation(String name);

}
