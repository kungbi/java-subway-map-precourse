package subway.repository;

import java.util.List;

public interface Repository<T> {

    void add(T data);

    void deleteStation(String name);

    int getSize();

    T findByName(String name);

    List<T> findAll();
}
