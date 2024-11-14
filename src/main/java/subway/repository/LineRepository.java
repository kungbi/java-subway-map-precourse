package subway.repository;

import java.util.ArrayList;
import java.util.List;
import subway.domain.Line;

public class LineRepository implements Repository<Line> {
    private static final List<Line> lines = new ArrayList<>();


    @Override
    public void add(Line data) {
        lines.add(data);
    }

    @Override
    public void add(Line data, int index) {
        lines.add(index, data);
    }

    @Override
    public boolean deleteStation(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                lines.remove(line);
                return true;
            }
        }
        return false;
    }
}
