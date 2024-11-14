package subway.repository;

import java.util.ArrayList;
import java.util.List;
import subway.domain.Line;

public class LineRepository implements Repository<Line> {
    private static final List<Line> lines = new ArrayList<>();

    @Override
    public void add(Line data) {

    }

    @Override
    public boolean deleteStation(String name) {
        return false;
    }
}
