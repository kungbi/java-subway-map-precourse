package subway.repository;

import java.util.ArrayList;
import java.util.List;
import subway.domain.Line;
import subway.domain.Station;

public class LineRepository implements Repository<Line> {
    private static final List<Line> lines = new ArrayList<>();

    public static void clear() {
        lines.clear();
    }

    public void addStation(Line line, Station station) {
        line.addStation(station);
    }

    public void addStation(Line line, Station station, int index) {
        line.addStation(station, index);
    }

    public void removeStation(Line line, Station station) {
        line.removeStation(station);
    }

    @Override
    public void add(Line line) {
        if (line == null) {
            throw new IllegalArgumentException();
        }
        if (findByName(line.getName()) != null) { // 중복 체크
            throw new IllegalArgumentException();
        }
        lines.add(line);
    }

    @Override
    public void remove(Line line) {
        lines.remove(line);
    }

    @Override
    public int getSize() {
        return lines.size();
    }

    @Override
    public Line findByName(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return line;
            }
        }
        return null;
    }

    @Override
    public List<Line> findAll() {
        return lines;
    }
}
